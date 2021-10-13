<html lang="en">
<#include "base.ftl">
<#macro title>Users</#macro>

<#macro content>
    Hello,
    <#if users??>
        <#if users?has_content>
            <#list users as u>
                ${u.firstName} ${u.secondName} ${u.login}
            </#list>!
        </#if>
    </#if>
</#macro>
</html>