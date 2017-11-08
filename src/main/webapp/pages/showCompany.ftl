<#include "./templates/header.ftl">
<div class="row">
    <div class="col-md-4 col-md-offset-4">
        <a href="/companies/${company.id}/addinfo" class="btn btn-success" style="width: 100%">Add info</a>
    </div>
</div>
<div class="container-fluid">
    <h3>Company</h3>
    <table class="table table-hover table-bordered" path="/liveEditCompany">
        <thead>
        <tr class="bg-primary">
            <th>Name</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Adress</th>
            <th>URL</th>
        </tr>
        </thead>
        <tr entityID="${company.id}">
            <td field="name">${company.name}</td>
            <td field="phone" type="phone">${company.phone}</td>
            <td field="email" type="email">${company.email}</td>
            <td field="adress">${company.adress}</td>
            <td field="url"><a href="${company.url}">${company.url}</a></td>
        </tr>
    </table>
    <hr>
<#if company.tasks?size != 0>
    <h3>Tasks</h3>
    <table class="table table-hover table-bordered" data-table='true' path="/liveEditTask" id="tasksTable">
        <thead>
        <tr class="bg-primary">
            <th>Date</th>
            <th>Description</th>
            <th>Checked</th>
            <th>Delete</th>
        </tr>
        </thead>
        <#list company.tasks as task>
            <tr entityID="${task.id}">
                <td field="dateExec" type="date">${task.dateExec?string("yyyy/MM/dd HH:mm")}</td>
                <td field="description">${task.description}</td>
                <td edit="false">
                    <input name="taskChecker"
                           type="checkbox"
                           <#if task.checker?string == 'true'>checked</#if>
                           data-taskId="${task.id}"
                    >
                    <p style="display: none">
                    ${task.checker?string}
                    </p>
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
    <hr>
<#if company.calls?size != 0>
    <h3>Calls</h3>
    <table class="table table-hover table-bordered" data-table='true' path="/liveEditCall">
        <thead>
        <tr class="bg-primary">
            <th>Date</th>
            <th>Description</th>
            <th>Delete</th>
        </tr>
        </thead>
        <#list company.calls as call>
            <tr entityID="${call.id}">
                <td field="date" type="date">${call.date?string("yyyy/MM/dd HH:mm")}</td>
                <td field="description">${call.description}</td>
                <td edit="false">
                    <form action="/deleteCall/${call.id}" method="post">
                        <input type="submit" class="btn btn-danger btn-sm" value="Exit">
                    </form>
                </td>
            </tr>
        </#list>
    </table>
</#if>
    <hr>
    <#if company.statuses?size != 0>
    <h3>Statuses</h3>
    <table class="table table-hover table-bordered" data-table="true" path="/liveEditStatus">
        <thead>
        <tr class="bg-primary">
            <th>Status</th>
            <th>Offers</th>
            <th>Delete</th>
        </tr>
        </thead>
        <#list company.statuses as status>
            <tr entityID="${status.id}">
                <td field="value">${status.value}</td>
                <td edit="false">
                    <ul>
                    <#list status.offers as offer>
                        <li>${offer.name}</li>
                    </#list>
                    </ul>
                </td>
                <td edit="false">
                    <form action="/deleteStatus/${status.id}" method="post">
                        <input type="submit" class="btn btn-danger btn-sm" value="Exit">
                    </form>
                </td>
            </tr>
        </#list>
    </table>
    <hr>
    </#if>
    <#if company.contactPeople?size != 0>
    <h3>Contact persons</h3>
    <table class="table table-hover table-bordered" data-table='true' path="/liveEditContactPerson">
        <thead>
        <tr class="bg-primary">
            <th>Name</th>
            <th>Lastname</th>
            <th>Position</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Delete</th>
        </tr>
        </thead>
    <#list company.contactPeople as contactPerson>
        <tr entityID="${contactPerson.id}">
            <td field="name">${contactPerson.name}</td>
            <td field="lastname">${contactPerson.lastname}</td>
            <td field="position">${contactPerson.position}</td>
            <td field="phone" type="phone">${contactPerson.phone}</td>
            <td field="email" type="email">${contactPerson.email}</td>
            <td edit="false">
                <form action="/deleteContactPerson/${contactPerson.id}" method="post">
                    <input type="submit" class="btn btn-danger btn-sm" value="Exit">
                </form>
            </td>
        </tr>
    </#list>
    </table>
    <hr>
    </#if>
</div>
</body>
</html>

<script src="/script/includeDataTable.js"></script>
<script src="/script/liveEdit.js"></script>
<script src="/script/updateValidation.js"></script>
<script src="/script/reverseTaskChecker.js"></script>
<script src="/script/colorfulTasks.js"></script>
