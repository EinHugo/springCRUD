<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../include/header.jsp"%>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">REGISTER BOARD</h3>
				</div>
				<!-- /.box-header -->

<form role="form" id="boardForm" method="post" action="registerBoard.sinc">
	<div class="box-body">
		<div class="form-group">
			<label for="exampleInputEmail1">Title</label> 
			<input type="text"
				name='title' class="form-control" placeholder="Enter Title">
		</div>
		<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo">이미지 링크 추가</button>
		<div class="form-group">
			<label for="exampleInputPassword1">Content</label>
			<textarea id="imageArea" class="form-control" name="content" rows="12"
				placeholder="Enter ..."></textarea>
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">Writer</label> 
			<input type="text"
				name="writer" class="form-control" readonly value="${loginUser.id}">
		</div>
	</div>
	<!-- /.box-body -->

	<div class="box-footer">
		<button id="submitBtn" type="button" class="btn btn-primary">Submit</button>
	</div>
</form>

<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">이미지 링크 추가</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
         <div class="form-group">
           <label for="message-text" class="col-form-label">이미지 URL:</label>
           <textarea class="form-control" id="imageLink"></textarea>
         </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
        <button type="button" id="addImage" class="btn btn-primary">이미지 추가</button>
      </div>
    </div>
  </div>
</div>


			</div>
			<!-- /.box -->
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<script>

String.prototype.replaceAll = function(org, dest) {
    return this.split(org).join(dest);
}

$("#submitBtn").on("click", function(e){
	e.preventDefault();
	
	var textarea = $("#imageArea").val();
	textarea = textarea.replaceAll("script", "");
	textarea = textarea.replaceAll("onerror", "");
	textarea = textarea.replaceAll("textarea", "");
	$("#imageArea").val(textarea);
	$("#boardForm").submit();
});

$("#addImage").on("click", function(){
	let imageHTML = '<center><img src="' + $("#imageLink").val() + '" style="width: 80%;" /></center>';
	
	$("#imageArea").val( $("#imageArea").val() + imageHTML);
	$("#exampleModal").modal('hide');
});
</script>

<%@include file="../include/footer.jsp"%>
