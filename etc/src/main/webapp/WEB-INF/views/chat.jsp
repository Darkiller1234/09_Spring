<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>채팅</h1>
    메세지 : <input type="text" name="msg">
    <br>
    수신자 : <input type="text" name="target">
    <br>
    
    <button onclick="sendMsg()">전송</button>

    <br>
    <div id="msg-container"></div>

    <script>
        const socket = new WebSocket("ws://localhost:7777/etc/server");


        socket.onopen = function() {
            console.log("연결 성공")
        }

        socket.onclose = function(){
            console.log("disconnection")
        }

        socket.onerror = function(){
            console.log("연결실패...")
        }

        socket.onmessage = function(ev){
            const reveice = JSON.parse(ev.data);

            const megContainer = document.querySelector("#msg-container");
            msgContainer.innerHTML += (reveice.nick + "(" + reveice.time + ") <br>" + reveice.msg + "<br>");
            
        }

        function sendMsg(){
            const msgData = {

            }
        }
    </script>
</body>
</html>