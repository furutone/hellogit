<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>hoge</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/pepper-grinder/jquery-ui-1.10.3.custom.css"
	rel="stylesheet">
<link href="css/skin-vista/ui.dynatree.css" rel="stylesheet"
	type="text/css" id="skinSheet">

<script src="js/jquery-1.9.1.js"></script>
<script src="js/jquery-ui-1.10.3.custom.js"></script>
<script type="text/javascript" src="js/jquery.dynatree.min.js"></script>


</head>
<body>
	<p>ppp</p>
	<%=new java.util.Date()%>
	<script>
		//文字列を JSON に変換
		var obj = JSON.parse('{"Name":"Yamada","Age":10}');
		//コンソールに内容を出力
		console.log("Name = " + obj.Name); //Name = Yamada
		console.log("Age = " + obj.Age); //Age = 10

		$(function() {
			$("p").click(function() {
				console.log("clicked ppp");
				$.ajax({
					async : false,
					type : 'POST',
					url : 'http://localhost:8080/wtpweb/getEmpJson',
					dataType : 'json',
				}).always(function(json) {
					console.log("EmployeeJson = " + json);
					console.log("stringfy" + JSON.stringify(json));
				});
			});
			function getJson() {
				$.ajax({
					async : false,
					type : 'POST',
					url : 'http://localhost:8080/wtpweb/getEmpJson',
					dataType : 'json',
				}).always(function(json) {
					console.log("ServletJson = " + json);
					console.log("stringfy" + JSON.stringify(json));
				});
			}

			$("#tree3")
					.dynatree(
							{
								checkbox : true,
								selectMode : 3,
								//children : treeData,
								initAjax : {
									url : "getDynaTreeData",
									data : {
										key : "root", // Optional arguments to append to the url
										mode : "all"
									}
								},
								onSelect : function(select, node) {
									// Get a list of all selected nodes, and convert to a key array:
									var selKeys = $.map(node.tree
											.getSelectedNodes(),
											function(node) {
												return node.data.key;
											});
									$("#echoSelection3").text(
											selKeys.join(", "));

									// Get a list of all selected TOP nodes
									var selRootNodes = node.tree
											.getSelectedNodes(true);
									// ... and convert to a key array:
									var selRootKeys = $.map(selRootNodes,
											function(node) {
												return node.data.key;
											});
									$("#echoSelectionRootKeys3").text(
											selRootKeys.join(", "));
									$("#echoSelectionRoots3").text(
											selRootNodes.join(", "));
								},
								onDblClick : function(node, event) {
									node.toggleSelect();
								},
								onKeydown : function(node, event) {
									if (event.which == 32) {
										node.toggleSelect();
										return false;
									}
								},
								// The following options are only required, if we have more than one tree on one page:
								//        initId: "treeData",
								cookieId : "dynatree-Cb3",
								idPrefix : "dynatree-Cb3-"
							});
		});
	</script>
	<!-- Tree #3 -->

	<p class="description">
		This tree has <b>checkoxes and selectMode 3 (hierarchical
			multi-selection)</b> enabled.<br> A double-click handler selects the
		node.<br> A keydown handler selects on [space].
	</p>
	<div id="tree3"></div>
	<div>
		Selected keys: <span id="echoSelection3">-</span>
	</div>
	<div>
		Selected root keys: <span id="echoSelectionRootKeys3">-</span>
	</div>
	<div>
		Selected root nodes: <span id="echoSelectionRoots3">-</span>
	</div>



</body>
</html>