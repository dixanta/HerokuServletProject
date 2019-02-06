<%@include  file="shared/header.jsp" %>
<h1>Customers</h1>

<table class="table">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Status</th>
        <th>Action</th>
    </tr>
    <c:forEach var="customer" items="${requestScope.customers}">
        <tr>
            <td>${customer.id}</td>
            <td>${customer.firstName} ${customer.lastName}</td>
            <td>${customer.email}</td>
            <td>${customer.status}</td>
            <td>Edit Delete</td>
        </tr>
        
    </c:forEach>
</table>


<%@include  file="shared/footer.jsp" %>