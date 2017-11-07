<#include "./templates/header.ftl">
<h3>Create Offer</h3>
<form action="/createOffer" method="post">
    <label>
        Name:
        <input type="text" name="name" placeholder="Offer name" required>
    </label>
    <input type="submit" class="btn btn-success btn-sm">
</form>
<br>
<br>
<#if offers?size != 0>
<table class="table table-hover table-bordered" data-table='true' path="/liveEditOffer">
    <thead>
    <tr class="bg-primary">
        <th>Offer name</th>
    </tr>
    </thead>
<#list offers as offer>
    <tr entityID="${offer.id}">
        <td field="name">${offer.name}</td>
    </tr>
</#list>
</table>
</#if>
</body>
</html>

<script src="/script/includeDataTable.js"></script>
<script src="/script/liveEdit.js"></script>