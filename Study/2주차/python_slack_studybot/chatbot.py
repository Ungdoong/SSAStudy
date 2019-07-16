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
from datetime import datetime

SLACK_TOKEN = 'xoxb-688411139621-678345631491-IxuS6voro1manBpTtxPyh3ZG'
SLACK_SIGNING_SECRET = '6006c95d2dace39b4928a199c18d8e24'

app = Flask(__name__)
# /listening 으로 슬랙 이벤트를 받습니다.
slack_events_adaptor = SlackEventAdapter(SLACK_SIGNING_SECRET, "/listening", app)
slack_web_client = WebClient(token=SLACK_TOKEN)

#유저 객체 클래스
class User:
    def __init__(self, user_id=None, topic=None, study_group=None, study_pair=None):
        self.user_id = '' if user_id is None else user_id
        #topic = 'python' or 'clang' or 'java' or 'english' or 'freestudy'
        self.topic = '' if topic is None else topic
        #study_group = 그룹이 없음 : 0 or 그룹이 존재 : 1 or 그룹을 찾는 중 : 2
        self.study_group = 0 if study_group is None else study_group
        #study_group = 페어가 없음 : 0 or 페어가 존재 : 1 or 페어을 찾는 중 : 2
        self.study_pair = 0 if study_pair is None else study_pair


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
def _make_category(name):
    head_section = SectionBlock(
        text="<@"+name+">\n*< 카테고리를 선택해주세요 >*",
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

#버튼을 클릭 시 실행 될 함수
def _button_response(topic, id):
    keyword_dis = ["Python", "C 언어", "자바", "영어", "자율학습","스터디 모임", "페어 스터디"]
    keywords = ['python', 'clang', 'java', 'english', 'freestudy', 'study_group', 'study_pair']
    topics = ['python', 'clang', 'java', 'english', 'freestudy']
    study_types = ['study_group', 'study_pair']
    for i in range(len(keywords)):
        if topic == keywords[i]:
            keyword_index = i

    if topic in topics:
        head_section = SectionBlock(
            text="<@" + id + ">\n"
            +"*< "+ keyword_dis[keyword_index] + "카테고리를 선택했습니다 >*\n"
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
    elif topic in study_types:
        head_section = SectionBlock(
            text="<@" + id + ">\n"
            +"*< " + keyword_dis[keyword_index] + "을 선택하셨습니다 >*\n"
            + "*< " + keyword_dis[keyword_index] + " 대기열에 등록했습니다 >*\n"
            + "*< 원하는 상대를 찾으면 알려드리겠습니다 ^__^ >*"
        )
        return [head_section]
    elif topic == 'already_group':
        head_section = SectionBlock(
            text="<@" + id + ">\n"
            +"*< 이미 그룹이 존재합니다. 그룹을 새로 찾길 원하시나요? >*\n"
        )
        button_actions = ActionsBlock(
            block_id="category",
            elements=[
                ButtonElement(
                    text="예",
                    action_id="already_group_yes", value="11",
                ),
                ButtonElement(
                    text="아니요",
                    action_id="already_group_no", value="12",
                ),
            ]
        )
        return [head_section, button_actions]
    elif topic == 'searching_group':
        head_section = SectionBlock(
            text="<@" + id + ">\n"
            +"*< 그룹을 찾고 있습니다. 중지할까요? >*\n"
        )
        button_actions = ActionsBlock(
            block_id="category",
            elements=[
                ButtonElement(
                    text="예",
                    action_id="searching_group_yes", value="11",
                ),
                ButtonElement(
                    text="아니요",
                    action_id="searching_group_no", value="12",
                ),
            ]
        )
        return [head_section, button_actions]
    elif topic == 'already_pair':
        head_section = SectionBlock(
            text="<@" + id + ">\n"
            +"*< 이미 페어가 존재합니다. 페어를 새로 찾길 원하시나요? >*\n"
        )
        button_actions = ActionsBlock(
            block_id="category",
            elements=[
                ButtonElement(
                    text="예",
                    action_id="already_pair_yes", value="11",
                ),
                ButtonElement(
                    text="아니요",
                    action_id="already_pair_no", value="12",
                ),
            ]
        )
        return [head_section, button_actions]
    elif topic == 'searching_pair':
        head_section = SectionBlock(
            text="<@" + id + ">\n"
            +"*< 페어을 찾고 있습니다. 중지할까요? >*\n"
        )
        button_actions = ActionsBlock(
            block_id="category",
            elements=[
                ButtonElement(
                    text="예",
                    action_id="searching_pair_yes", value="11",
                ),
                ButtonElement(
                    text="아니요",
                    action_id="searching_pair_no", value="12",
                ),
            ]
        )
        return [head_section, button_actions]
    elif topic == 'searching_stop':
        head_section = SectionBlock(
            text="<@" + id + ">\n"
            +"*< 매칭을 중지하였습니다 >*\n"
        )
        return [head_section]
    elif topic == 'none_user':
        head_section = SectionBlock(
            text="<@" + id + ">\n"
            +"*< 카테고리를 먼저 선택해주세요 >*\n"
        )
        return [head_section]

#CSV 파일의 유저정보를 유저객체의 리스트 형태로 변환
def load_CSV(filename):
    user_list = []
    with open(filename) as file:
        for line in file.readlines():
            if line != '':
                tmp_user = line.strip().split(',')
                if len(tmp_user) == 4:
                    user = User(tmp_user[0], tmp_user[1], int(tmp_user[2]), int(tmp_user[3]))
                user_list.append(user)

    return user_list

#유저 리스트를 CSV파일에 저장
def save_CSV(filename, user_list):
    with open(filename, 'w') as file:
        for user in user_list:
            string = ','.join([user.user_id, user.topic,str(user.study_group),str(user.study_pair)])
            string += '\n'
            file.write(string)

# 챗봇이 멘션을 받았을 경우
@slack_events_adaptor.on("app_mention")
def app_mentioned(event_data):
    channel = event_data["event"]["channel"]
    text = event_data["event"]["text"]
    user_name = event_data["event"]["user"]
    
    matches = re.search(r"<@U\w+>\s+(.+)", text)
    if matches:
        keyword = matches.group(1)
    else:
        keyword = ''

    if keyword == '카테고리':
        category_blocks = _make_category(user_name)

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

# / 로 접속하면 서버가 준비되었다고 알려줍니다.
@app.route("/", methods=["GET"])
def index():
    return "<h1>Server is ready.</h1>"

#클릭 이벤트
@app.route("/click", methods=["GET", "POST"])
def on_button_clicked():
    #유저 정보 읽어오기 및 변수 초기화
    user_list = load_CSV('user_list.csv')
    group_wait_list = load_CSV('group_wait_list.csv')
    pair_wait_list = load_CSV('pair_wait_list.csv')
    log = ''
    now = datetime.now()

    #페이로드 읽어오기
    payload = request.values["payload"]
    click_event = MessageInteractiveEvent(json.loads(payload))
    user_id = click_event.user.id
    action_id = click_event.action_id
    
    #로그 기록
    str_log = str(now) + '\t' + user_id + " " + action_id + " 선택"
    print(str_log)
    log += str_log + "\n"
    with open('log.txt', 'a') as log_file:
        log_file.write(log)
    
    #실행 위치에 따라 유저정보 업데이트
    if action_id == 'study_group':
        for user in user_list:
            if user.user_id == user_id and user.study_group == 1:
                action_id = 'already_group'
            elif user.user_id == user_id and user.study_group == 2:
                action_id = 'searching_group'
            elif user.user_id == user_id and user.study_group == 0:
                user.study_group = 2
            else:
                action_id = 'none_user'
        if not user_list:
            action_id = 'none_user'
    elif action_id == 'study_pair':
        for user in user_list:
            if user.user_id == user_id and user.study_pair == 1:
                action_id = 'already_pair'
            elif user.user_id == user_id and user.study_pair == 2:
                action_id = 'searching_pair'
            elif user.user_id == user_id and user.study_pair == 0:
                user.study_pair = 2
            else:
                action_id = 'none_user'
        if not user_list:
            action_id = 'none_user'
    elif action_id == 'already_group_yes':
        action_id = 'study_group'
        for user in user_list:
            if user.user_id == user_id and user.study_group == 1:
                user.study_group = 2
            else:
                return "OK", 200
        if not user_list:
            return "OK", 200
        #TODO : 같은 그룹원에게 메시지처리함수
    elif action_id == 'already_pair_yes':
        action_id = 'study_pair'
        for user in user_list:
            if user.user_id == user_id and user.study_pair == 1:
                user.study_pair = 2
            else:
                return "OK", 200
        if not user_list:
            return "OK", 200
        #TODO : 페어에게 메시지처리함수    
    elif action_id == 'searching_group_yes':
        action_id = 'searching_stop'
        for user in user_list:
            if user.user_id == user_id and user.study_group == 2:
                user.study_group = 0
            else:
                return "OK", 200
        if not user_list:
            return "OK", 200
    elif action_id == 'searching_pair_yes':
        action_id = 'searching_stop'
        for user in user_list:
            if user.user_id == user_id and user.study_pair == 2:
                user.study_pair = 0
            else:
                return "OK", 200
        if not user_list:
            return "OK", 200
    elif action_id == 'already_group_no':
        return "OK", 200
    elif action_id == 'already_pair_no':
        return "OK", 200
    elif action_id == 'searching_group_no':
        return "OK", 200
    elif action_id == 'searching_pair_no':
        return "OK", 200
    else:
        topic = action_id
        user_list.append(User(user_id=user_id,topic=topic))
        
    category_blocks = _button_response(action_id, user_id)
    
    slack_web_client.chat_postMessage(
        channel=click_event.channel.id,
        blocks=extract_json(category_blocks)
    )

    save_CSV('user_list.csv', user_list)
    
    return "OK", 200

if __name__ == '__main__':
    app.run('127.0.0.1', port=8080)