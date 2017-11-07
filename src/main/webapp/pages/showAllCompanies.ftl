<#include "./templates/header.ftl">
<h3>Create company</h3>
<form action="/createCompany" method="post">
    <label>
        Name:
        <input type="text" name="name" placeholder="Name" required>
    </label>
    <label>
        Phone:
        <input type="tel" name="phone" placeholder="Phone" required>
    </label>
    <label>
        Email:
        <input type="email" name="email" placeholder="Email" required>
    </label>
    <label>
        Adress:
        <input type="text" name="adress" placeholder="Adress" required>
    </label>
    <label>
        URL:
        <input type="url" name="url" placeholder="URL" required>
    </label>
    <input type="submit" class="btn btn-success btn-sm">
</form>
<br>
<#if companies?size != 0>
<table class="table table-hover table-bordered" data-table='true' path="/liveEditCompany">
    <thead>
    <tr class="bg-primary">
        <th>Name</th>
        <th>Phone</th>
        <th>Email</th>
        <th>Adress</th>
        <th>URL</th>
    </tr>
    </thead>
<#list companies as company>
    <tr entityID="${company.id}">
        <td field="name"><a href="/companies/${company.id}">${company.name}</a></td>
        <td field="phone" type="phone">${company.phone}</td>
        <td field="email" type="email">${company.email}</td>
        <td field="adress">${company.adress}</td>
        <td field="url"><a href="${company.url}">${company.url}</a></td>
    </tr>
</#list>
</table>
</#if>
</body>
</html>

<script src="/script/includeDataTable.js"></script>
<script src="/script/liveEdit.js"></script>
<script src="/script/updateValidation.js"></script>