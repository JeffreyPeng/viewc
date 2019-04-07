<#assign title="manage">
<#assign isHeartBeat="active">
<#include "header.ftl">

<div class="container">


    <h2>近期心跳</h2>

    <table class="table">
        <tr>
            <th>主机名</th>
            <th>外网地址</th>
            <th>时间</th>
        </tr>

    <#list list as hb>
        <tr>
            <td>${hb.hostName!}</td>
            <td>${hb.ip!}</td>
            <td>${(hb.recvTime?string["yyyy-MM-dd HH:mm:ss"])!}</td>
        </tr>
    </#list>
    </table>

    <a class="btn btn-primary" href="clearHeartBeat" role="button">清空</a>
</div>

<#include "footer.ftl">