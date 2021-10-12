<html lang="en">
<#include "base.ftl">
<#macro title>Профиль</#macro>
<#macro content>
    <#if user?has_content>
        <h2>Hello ${user.login}!</h2>
        <p>Your first name: ${user.firstName}</p>
        <p>Your last name ${user.secondName}</p>
    </#if>
</#macro>
<form action="/login"
</html>
