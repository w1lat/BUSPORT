<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<h1>Drivers</h1>

<br/>

<table class="table table-striped table-bordered table-hover">
    <tbody>
    <c:forEach items="${drivers}" var="driver">
        <tr>
            <td>
                    ${driver.id}
            </td>
            <td>
                    ${driver.name}
            </td>
            <td>
                    ${driver.surName}
            </td>
            <td>
                    ${driver.lastName}
            </td>
            <td>
                    ${driver.birthDay}
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
