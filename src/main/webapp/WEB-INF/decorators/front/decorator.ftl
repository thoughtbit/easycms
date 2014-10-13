<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">	
		<title><sitemesh:write property='title'/></title>
		<meta name="description" content="<tiles:insertAttribute name="page_description" ignore="true"/>">	
		<sitemesh:write property='head'/>
	</head>
    <body>
    	<!-- front decorator -->
		<sitemesh:write property='body'/>
	</body>
</html>
