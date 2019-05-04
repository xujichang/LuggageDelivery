<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/head.jsp"%>
<h2 class="contentTitle">反馈 信息</h2>
<div class="pageContent">
	<form method="post" action="${ctx}/sys/updateFeedback.action" class="pageForm required-validate" enctype="multipart/form-data" onsubmit="return iframeCallback(this)">
		<input type="hidden" value="${modifybean.id}" name="id"/>
		<div class="pageFormContent" layoutH="97">
			<table>
					<tr>
						<td colspan="2"><dl>
							<dt>反馈内容：</dt>
							<dd>
								<textarea rows="15" cols="60" name="content">${modifybean.content }</textarea>
							</dd>
							</dl></td>
					</tr>
					 
				</table>
		</div>
		<div class="formBar">
		<c:if test="${SESSION_BEAN.role=='SimpleUser' && SESSION_BEAN.user.userType=='用户' }">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="reset" class="reset">重置</button></div></div></li>
			</ul>
		</c:if>
		</div>
	</form>
</div>
