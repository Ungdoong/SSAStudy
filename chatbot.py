# -*- coding: utf-8 -*-
import re
import json
import urllib.request

from bs4 import BeautifulSoup
from flask import Flask, request
from slack import WebClient
from slack.web.classes import extract_json
from slack.web.classes.blocks import *
from slack.web.classes.elements import *
from slack.web.classes.interactions import MessageInteractiveEvent
from slackeventsapi import SlackEventAdapter

SLACK_TOKEN = 'xoxb-688411139621-678345631491-Zu9tWUbq79hqAmxha044CLwN'
SLACK_SIGNING_SECRET = '6006c95d2dace39b4928a199c18d8e24'

app = Flask(__name__)
# /listening 으로 슬랙 이벤트를 받습니다.
slack_events_adaptor = SlackEventAdapter(SLACK_SIGNING_SECRET, "/listening", app)
slack_web_client = WebClient(token=SLACK_TOKEN)


# 크롤링 함수 구현하기
def _crawl_portal_keywords(text):
    # url_match = re.search(r'<(http.*?)(\|.*?)?>', text)
    # if not url_match:
    #     return '올바른 URL을 입력해주세요.'

    # url = url_match.group(1)
    # source_code = urllib.request.urlopen(url).read()
    # soup = BeautifulSoup(source_code, "html.parser")

    if 'naver' in text or '네이버' in text:
        url = 'http://www.naver.com'
        tag_name = "span"
        class_name = "ah_k"
    elif 'bugs' in text or '벅스' in text:
        url = 'https://music.bugs.co.kr/'
        tag_music = "p"
        class_music = "title"
        tag_artist = "p"
        class_artist = "artist"
    else:
        url = 'http://www.daum.net'
        tag_name = "a"
        class_name = "link_issue"

    source_code = urllib.request.urlopen(url).read()
    soup = BeautifulSoup(source_code, "html.parser")

    # 여기에 함수를 구현해봅시다.
    keywords = []
    if not 'bugs' in text and not '벅스' in text:
        for tag in soup.find_all(tag_name, class_=class_name):
            word = tag.get_text().strip()
            if not word in keywords:
                keywords.append(word)
    else:
        soup = soup.find("table", class_="list trackList")
        musics = soup.find_all(tag_music, class_= class_music)
        artists = soup.find_all(tag_artist, class_=class_artist)
        for i in range(10):
            if i == 0:
                keywords.append("Bugs 실시간 음악 차트 Top 10\n")
            artist = artists[i].get_text().strip()
            if '\n' in artist:
                artist = artist.split('\n')[3]
            keywords.append(str(i+1) + '위 : ' + musics[i].get_text().strip() + ' / ' + artist)


    # 키워드 리스트를 문자열로 만듭니다.
    return '\n'.join(keywords)

#instructions.txt의 내용을 출력하기 위한 함수
def _dis_instructions():
    inst_list = []
    with open('instructions.txt', encoding='UTF-8') as file:
        for line in file.readlines():
            inst_list.append(line)

    return ''.join(inst_list)

#카테고리 블록을 생성하는 함수
def _make_category():
    head_section = SectionBlock(
        text="*< 카테고리를 선택해주세요 >*",
    )
    button_actions = ActionsBlock(
        block_id="category",
        elements = [
            ButtonElement(
                text= "Python",
                action_id="python", value="1",
            ),
            ButtonElement(
                text="C 언어",
                action_id="clang", value="2",
            ),
            ButtonElement(
                text="자바",
                action_id="java", value="2",
            ),
            ButtonElement(
                text="영어",
                action_id="english", value="3",
            ),
            ButtonElement(
                text="자율학습",
                action_id="freestudy", value="4",
            ),
        ]
    )

    return [head_section, button_actions]

#카테고리 버튼을 클릭 시 실행 될 함수
def _remake_category(topic):
    topics = ["Python", "C 언어", "자바", "영어", "자율학습"]
    selections = [ "스터디 모임", "페어 스터디"]
    selection_flag = False
    if topic == 'python':
        topic_index = 0
    elif topic == 'clang':
        topic_index = 1
    elif topic == 'java':
        topic_index = 2
    elif topic == 'english':
        topic_index = 3
    elif topic == 'freestudy':
        topic_index = 4
    elif topic == 'study_group':
        selection_index = 0
        selection_flag = True
    elif topic == 'study_pair':
        selection_index = 1
        selection_flag = True

    if selection_flag == False:
        head_section = SectionBlock(
            text="*< "+ topics[topic_index] + "카테고리를 선택했습니다 >*\n"
            + "*< 원하시는 형태를 선택해주세요. >*",
        )
        button_actions = ActionsBlock(
            block_id="category",
            elements=[
                ButtonElement(
                    text="스터디 모임",
                    action_id="study_group", value="11",
                ),
                ButtonElement(
                    text="페어 스터디",
                    action_id="study_pair", value="12",
                ),
            ]
        )
        return [head_section, button_actions]
    else:
        head_section = SectionBlock(
            text="*< " + selections[selection_index] + "을 선택하셨습니다 >*\n"
            + "*< " + selections[selection_index] + " 매칭을 시작하겠습니다 >*"
        )
        return [head_section]


# 챗봇이 멘션을 받았을 경우
@slack_events_adaptor.on("app_mention")
def app_mentioned(event_data):
    channel = event_data["event"]["channel"]
    text = event_data["event"]["text"]

    matches = re.search(r"<@U\w+>\s+(.+)", text)
    if matches:
        keyword = matches.group(1)
    else:
        keyword = ''

    if keyword == '카테고리':
        category_blocks = _make_category()

        slack_web_client.chat_postMessage(
            channel=channel,
            blocks=extract_json(category_blocks)
        )
    else:
        keywords = _dis_instructions()
        slack_web_client.chat_postMessage(
            channel=channel,
            text=keywords
        )

#CSV 파일의 유저정보를 딕셔너리의 리스트 형태로 변환
def load_CSV():
    user_list = []
    with open('user_list.csv') as file:
        for line in file.readlines():
            user = {}
            tmp_user = line.strip().split(',')
            user['user_id'] = tmp_user[0]
            user['topic'] = tmp_user[1]
            user_list.append(user)

    return user_list


# / 로 접속하면 서버가 준비되었다고 알려줍니다.
@app.route("/", methods=["GET"])
def index():
    return "<h1>Server is ready.</h1>"

@app.route("/click", methods=["GET", "POST"])
def on_button_clicked():
    #유저 정보 읽어오기 및 변수 초기화
    # user_list = load_CSV()
    selections = ["study_group", "study_pair"]

    #페이로드 읽어오기
    payload = request.values["payload"]
    click_event = MessageInteractiveEvent(json.loads(payload))

    #클릭한 버튼에 따라 블록 재생성
    action_id = click_event.action_id
    if action_id in selections:
        selection = action_id
        category_blocks = _remake_category(selection)
    else:
        topic = action_id
        category_blocks = _remake_category(topic)

    #유저 아이디와 토픽을 딕셔너리에 추가 또는 수정
    # user_id = click_event.user.id
    # for user in user_list:
    #     if user['user_id'] == user_id:
    #         user['topic'] = topic
    #     else:
    #         user_list.append({'user_id': user_id, 'topic': topic})

    slack_web_client.chat_postMessage(
        channel=click_event.channel.id,
        blocks=extract_json(category_blocks)
    )

    return "OK", 200

if __name__ == '__main__':
    app.run('127.0.0.1', port=8080)