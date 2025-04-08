<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <jsp:include page="../layout/header.jsp"/>   
   
   <div class="page-header">
      <h1>게시글 수정&삭제</h1>
   </div>
   <div class="panel-body">
      <form method="POST" enctype="multipart/form-data">
         <table>
            <tbody>
               <tr>
                  <th>글 번호</th>
                  <td><input type="text" name="bno" value="${vo.bno}" readonly></td>
               </tr>
               <tr>
                  <th>제목</th>
                  <td><input type="text" name="title" value="${vo.title }"></td>
               </tr>
               <tr>
                  <th>작성자</th>
                  <td><input type="text" name="writer" value="${vo.writer }" readonly></td>
               </tr>
               <tr>
                  <th>내용</th>
                  <td>
                     <textarea rows="10" cols="76" name="content">${vo.content }</textarea>
                  </td>
               </tr>
            </tbody>
         </table>
         <input type="hidden" name="pageNum" value="${cri.pageNum }" >
         <input type="hidden" name="amount" value="${cri.amount }" >
   	</div>
    <div class="file-container">
   	  <div class="file-header">
         <div class="file-title">
           <a>파일 첨부</a>
         </div>
   	   </div>
   	   <div class="file-body">
         <div class="uploadDiv">
         	<button id="chooseFile" type="button">파일 선택</button>
            <input type="file" name="uploadFile" multiple="multiple" hidden>
         </div>

         <div class="uploadResult">
           <ul></ul>
         </div>
      </div>
   </div>
      </form>
   <div class="panel-body-btns">
      <button type="button" class="btn btn-sec" id="modifyBtn">수정</button>
      <button type="button" class="btn btn-thi" id="removeBtn">삭제</button>
      <button type="button" class="btn btn-fir" id="indexBtn">목록으로 이동</button>
   </div>
   <div>
   	<c:forEach var="item" items="${attachList }">
   		<div class="attachItem" hidden uuid="${item.uuid }" uploadPath="${item.uploadPath }" fileName="${item.fileName }"></div>
   	</c:forEach>
   </div>
   	<div id="page-data" 
     pageNum="${cri.pageNum}" 
     amount="${cri.amount}">
	</div>
   <jsp:include page="../layout/footer.jsp"/>
   <script type="text/javascript" src="/resources/js/modify.js"></script>   
</body>
</html>