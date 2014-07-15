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
		 table tbody tr.even.row_selected td{
			background-color: #B0BED9 !important;
		 }
    </style>
    <!--external css-->
    <title>User Edit</title>
  </head>
<body>

<!--main content start-->
  <section class="panel">
    <header class="panel-heading">
        User Edit
    </header>
     <form role="form" class="form-horizontal tasi-form" action="${rootPath}/user/save.action">
         <div class="form-group has-success">
             <label class="col-lg-2 control-label">Group Name</label>
             <div class="col-lg-10">
                 <input name="userGroup.id" type="hidden" value="${userGroup.id}"/>
                 <input type="text" placeholder="" id="f-name" name="userGroup.name" class="form-control" required="required" value="${userGroup.name}">
             </div>
         </div>

         <div class="form-group">
             <div class="col-lg-offset-2 col-lg-10">
                 <button class="btn btn-info" type="submit">Save</button>
					<button class="btn btn-info" type="button" onclick="window.location.href='${rootPath}/usergroup/usergroup/index.action'">取消</button>
             </div>
         </div>
     </form>
  </section>
</body>
</html>