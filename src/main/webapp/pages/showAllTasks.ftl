<#include "./templates/header.ftl">

<h3>Tasks</h3>
<form action="/createTask" method="post">
    <label>
        Date:
        <input type="datetime-local" name="dateExec" placeholder="date" required>
    </label>
    <label>
        Description
        <input type="text" name="description" placeholder="description" value="">
    </label>
    <label for="company">Select company:
        <select class="js-example-basic-single js-states form-control" id="company" name="companyId" required>
            <#list companies as company>
                <option value="${company.id}">${company.name}</option>
            </#list>
        </select>
    </label>
    <input type="submit" value="Create" class="btn btn-success btn-sm">
</form>
<br>
<#if tasks?size != 0>
<table class="table table-hover table-bordered" data-table='true' path="/liveEditTask">
    <thead>
    <tr class="bg-primary">
        <th>Date</th>
        <th>Description</th>
        <th>Company</th>
        <th>Checked</th>
        <th>Delete</th>
    </tr>
    </thead>
<#list tasks as task>
    <tr entityID="${task.id}">
        <td field="dateExec" type="date">${task.dateExec?string("yyyy/MM/dd HH:mm")}</td>
        <td field="description">${task.description}</td>
        <td edit="false">
            <a href="/companies/${task.company.id}">${task.company.name}</a>
        </td>
        <td edit="false">
            <input name="taskChecker"
                   type="checkbox"
                   <#if task.checker?string == 'true'>checked</#if>
                   data-taskId="${task.id}"
            >
        </td>
        <td edit="false">
            <form action="/deleteTask/${task.id}" method="post">
                <input type="submit" class="btn btn-danger btn-sm" value="Exit">
            </form>
        </td>
    </tr>
</#list>
</table>
</#if>
<script src="/script/select2.js"></script>
<script src="/script/includeDataTable.js"></script>
<script src="/script/liveEdit.js"></script>
<script src="/script/updateValidation.js"></script>
<script src="/script/reverseTaskChecker.js"></script>
</body>
</html>