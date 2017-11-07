<#include "./templates/header.ftl">
<div class="row">
    <div class="col-md-4 col-md-offset-4">
        <a href="/companies/${company.id}" class="btn btn-success" style="width: 100%">${company.name}</a>
    </div>
</div>
<h3>Create contact person</h3>
<form action="/createContactPerson" method="post">
    <label>
        Name:
        <input type="text" name="name" placeholder="name" required>
    </label>
    <br>
    <label>
        Lastname
        <input type="text" name="lastname" placeholder="lastname" required>
    </label>
    <br>
    <label>
        Position:
        <input type="text" name="position" placeholder="position" required>
    </label>
    <br>
    <label>
        Phone:
        <input type="tel" name="phone" placeholder="phone" value="">
    </label>
    <br>
    <label>
        Email:
        <input type="email" name="email" placeholder="email" value="">
    </label>
    <br>
    <input type="hidden" name="companyId" value="${company.id}">
    <input type="submit" value="Create" class="btn btn-success btn-sm">
</form>
<hr>
<h3>Create call</h3>
<form action="/createCall" method="post">
    <label>
        Date:
        <input type="datetime-local" name="date" placeholder="date" required>
    </label>
    <label>
        Description
        <input type="text" name="description" placeholder="description" value="">
    </label>
    <input type="hidden" name="companyId" value="${company.id}">
    <input type="submit" value="Create" class="btn btn-success btn-sm">
</form>
<hr>
<h3>Create task</h3>
<form action="/createTask" method="post">
    <label>
        Date:
        <input type="datetime-local" name="dateExec" placeholder="date" required>
    </label>
    <label>
        Description
        <input type="text" name="description" placeholder="description" value="">
    </label>
    <input type="hidden" name="companyId" value="${company.id}">
    <input type="submit" value="Create" class="btn btn-success btn-sm">
</form>
<hr>
<h3>Create status</h3>
<form action="/createStatus" method="post">
    <label>
        Satatus:
        <input type="text" name="value" placeholder="Status" required>
    </label>
    <label>
        Description
        <input type="text" name="description" placeholder="description" value="">
    </label>
    <label for="company">Select offers:
        <select class="js-example-basic-multiple js-states form-control" multiple id="offersIds" name="offersIds" required>
        <#list offers as offer>
            <option value="${offer.id}">${offer.name}</option>
        </#list>
        </select>
    </label>
    <input type="hidden" name="companyId" value="${company.id}">
    <input type="submit" value="Create" class="btn btn-success btn-sm">
</form>
<hr>
<script src="/script/select2.js"></script>
<script src="/script/liveEdit.js"></script>
<script src="/script/updateValidation.js"></script>
</body>
</html>