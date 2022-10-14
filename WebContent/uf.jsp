<!doctype html>
<jsp:useBean id="Uf" type="model.Uf" scope="session"></jsp:useBean>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="pt-br">

<p><c:out value="${Uf.id}"/></p>
<p><c:out value="${Uf.uf}"/></p>
<p><c:out value="${Uf.descricao}"/></p>
<!----- Footer ----->
<%@include file="../include/rodape.jsp"%>
</html>

