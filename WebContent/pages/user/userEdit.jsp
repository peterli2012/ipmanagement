<!DOCTYPE html>
<html lang="en">
<%@ include file="../commonHeader.jsp"%>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Mosaddek">
<meta name="keyword" content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<link rel="shortcut icon" href="img/favicon.png">

<style type="text/css">
table tbody tr.even.row_selected td {
	background-color: #B0BED9 !important;
}
</style>
<!--external css-->
<title>User Edit</title>
</head>
<body>

	<!--main content start-->
	<section class="panel">
		<header class="panel-heading"> User Edit </header>
		<form role="form" class="form-horizontal tasi-form" action="${rootPath}/user/save.action">
			<div class="form-group has-success">
				<label class="col-lg-2 control-label">Owner</label>
				<div class="col-lg-10">
					<input name="user.id" type="hidden" value="${user.id}" /> <input type="text" placeholder="" name="user.name" class="form-control"
						required="required" value="${user.name}">
				</div>
			</div>
			<div class="form-group has-success">
				<label class="col-lg-2 control-label">User Group</label>
				<div class="col-lg-10">
					<select name="user.ugroup" value="${user.ugroup}">
					    <s:iterator value="userGroup">
					       <option value="${id}">${name}</option>
					    </s:iterator>
					</select>
				</div>
			</div>
			<div class="form-group has-success">
				<label class="col-lg-2 control-label">Email</label>
				<div class="col-lg-10">
					<input type="text" placeholder="" name="user.email" class="form-control" value="${user.email}">
				</div>
			</div>
			<div class="form-group has-success">
				<label class="col-lg-2 control-label">Location</label>
				<div class="col-lg-10">
					<input type="text" placeholder="" name="user.location" class="form-control" value="${user.location}">
				</div>
			</div>
			<div class="form-group has-success">
				<label class="col-lg-2 control-label">Comments</label>
				<div class="col-lg-10">
					<input type="text" placeholder="" name="user.comments" class="form-control" value="${user.comments}">
				</div>
			</div>
			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<button class="btn btn-info" type="submit">保存</button>
					<button class="btn btn-info" type="button" onclick="window.location.href='${rootPath}/user/user/index.action'">取消</button>
				</div>
			</div>
		</form>
	</section>
</body>
</html>