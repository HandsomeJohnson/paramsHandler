<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<title>WebSocket</title>
<script src="<%=path%>/js/sockjs-0.3.4.js"></script>
<script src="<%=path%>/js/stomp.js"></script>
<script src="<%=path%>/js/jquery-1.7.2.min.js"></script>

<script type="text/javascript">
	var stompClient = null;

	function setConnected(connected) {

	}

	function connect() {
		var socket = new SockJS('/paramsHandler/stomp');
		stompClient = Stomp.over(socket);
		stompClient.connect({}, function(frame) {
			setConnected(true);
			console.log('Connected: ' + frame);
			stompClient.subscribe('/topic/modelacceptor', function(model) {
				showGreeting(model.body);
			});
			
			stompClient.subscribe('/topic/greetings', function(greeting) {
				showGreeting(greeting.body);
				//showGreeting(greeting);
				//console.log(greeting);
				//console.log(greeting.body);
			});
		});
	}

	function disconnect() {
		if (stompClient != null) {
			stompClient.disconnect();
			setConnected(false);
			console.log("Disconnected");
		}
	}

	function sendName() {
		var name = document.getElementById('name').value;
		stompClient.send("/app/hello", {}, name);
	}
	
	function sendModelID(){
		var data = {
				 "cmd":"generate",
			   	   "jobID":"dbnsaldbsalihu695865732",
			   	   "params":{
			   	   		"id":"000000001",
			   	   		"params":[
			   	   		  		{"name":"长","type":"d","values":["10"]},
			   					{"name":"宽","type":"d","values":["10"]},
			   					{"name":"高","type":"d","values":["10"]}
			   	   		]
			   	   },
			   	   "path":"./tmp/box3333333"
			   

		};
		stompClient.send("/app/hello", {}, JSON.stringify(data));
	}
	
	function paramsChange(){  
		var data = {
			    "cmd": "generate",
			    "jobId": 1,
			    "hxModels": [
			        {
			            "id": "000000005",
			            "modelname": "GroupTest",
			            "description": "Group测试",
			            "savepath": null,
			            "modelversion": null,
			            "lastmodify": null,
			            "hxModels": [
			                {
			                    "id": "000000001",
			                    "modelname": "Box",
			                    "description": "简易长方体",
			                    "savepath": null,
			                    "modelversion": null,
			                    "lastmodify": null,
			                    "hxModels": [],
			                    "hxParams": [
			                        {
			                            "id": 2,
			                            "paramname": "宽",
			                            "paramtype": "d",
			                            "paramvalue": 10,
			                            "paramorder": null
			                        },
			                        {
			                            "id": 3,
			                            "paramname": "高",
			                            "paramtype": "d",
			                            "paramvalue": 1.2,
			                            "paramorder": null
			                        },
			                        {
			                            "id": 1,
			                            "paramname": "长",
			                            "paramtype": "d",
			                            "paramvalue": 10,
			                            "paramorder": null
			                        }
			                    ]
			                },
			                {
			                    "id": "000000002",
			                    "modelname": "Bottle",
			                    "description": "OCC瓶子",
			                    "savepath": null,
			                    "modelversion": null,
			                    "lastmodify": null,
			                    "hxModels": [],
			                    "hxParams": [
			                        {
			                            "id": 5,
			                            "paramname": "高",
			                            "paramtype": "d",
			                            "paramvalue": 100,
			                            "paramorder": null
			                        },
			                        {
			                            "id": 6,
			                            "paramname": "瓶子厚度",
			                            "paramtype": "d",
			                            "paramvalue": 30,
			                            "paramorder": null
			                        },
			                        {
			                            "id": 4,
			                            "paramname": "宽",
			                            "paramtype": "d",
			                            "paramvalue": 50,
			                            "paramorder": null
			                        }
			                    ]
			                }
			            ],
			            "hxParams": [
			                {
			                    "id": 7,
			                    "paramname": "宽",
			                    "paramtype": "d",
			                    "paramvalue": 50,
			                    "paramorder": null
			                }
			            ]
			        }
			    ]
			};
		stompClient.send("/app/paramschange", {}, JSON.stringify(data));
/* 			$.ajax({
				type : "POST",
				url : contextPath + '/mvc/test',
				dataType : "json",
				contentType : "application/json",
				data : JSON.stringify(data),

				success : function(data) {
					  console.log(data);
				}
			}); */
		}

	
	function paramsChange1(){  
		var contextPath = "<%=request.getContextPath()%>";
		var data = {
			   	   "cmd":"generate",
			   	   "jobID":"dbnsaldbsalihu695865732",
			   	   "params":{
			   	   		"id":"000000001",
			   	   		"params":[
			   	   		  		{"name":"长","type":"d","values":["10"]},
			   					{"name":"宽","type":"d","values":["10"]},
			   					{"name":"高","type":"d","values":["10"]}
			   	   		]
			   	   },
			   	   "path":"./tmp/box3333333"
			   

		};
			$.ajax({
				type : "POST",
				url : contextPath + '/systemmodel/000000005',
				dataType : "json",
				contentType : "application/json",
				data : JSON.stringify(data),

				success : function(data) {
					  console.log(data);
				}
			});
		}
	
	function List(){  
		var contextPath = "<%=request.getContextPath()%>";
		var data = {
				"modelname":"GroupTest",
				
			   	  		};
			$.ajax({
				type : "POST",
				url : contextPath + '/systemmodel/list',
				//dataType : "json",
				//contentType : "application/json",
				data : data,//JSON.stringify(data),

				success : function(data) {
					  console.log(data);
				}
			});
		}
	function showGreeting(message) {
		var response = document.getElementById('response');
		var p = document.createElement('p');
		p.style.wordWrap = 'break-word';
		p.appendChild(document.createTextNode(message));
		response.appendChild(p);
	}
	
	function init(){
		connect();
		
	}
</script>
</head>
<body onload="connect()">
	<noscript>
		<h2 style="color: #ff0000">Seems your browser doesn't support
			Javascript! Websocket relies on Javascript being enabled. Please
			enable Javascript and reload this page!</h2>
	</noscript>
	<div>

		<div id="conversationDiv">
			<button id="sendModelID" onclick="sendModelID();">按编号获取模型</button>
			<button id="paramsChange" onclick="paramsChange();">paramsChange</button>
			<button id="List" onclick="List();">List</button>
			<p id="response"></p>
		</div>
		
		<div>${hxJob.jobId}</div>
		<div>${hxJob.hxModels}</div>
	</div>
</body>
</html>
