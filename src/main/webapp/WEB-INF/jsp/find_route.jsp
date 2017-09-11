<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All app on one tab</title>
</head>
<body>

    <h1 style="text-align: center">Hello my friend</h1>

    <h2 style="text-align: center">Welcome to all application in one page</h2>

    <h3 style="text-align: center">Please press the button, which maximally describes what you'd like to do :-)</h3>
    <div style="text-align: center">
        <button id="btnCreateContact">Create New Contact</button>
        <button id="btnShowAllContacts">Show All Contacts</button>
        <button id="btnShowContactById">Show Contact By Id</button>
    </div>

    <br>
    <div>
        Name: <input type="text" id="userName"/>

        Last name: <input type="text" id="userLastName"/>

        Contact group: <input type="text" id="userGroup"/>

        Phone number: <input type="text" id="userNumber"/>

        Email: <input type="text" id="userEmail"/>

        Birhtday: <input type="text" id="userBirthday"/>

        Id: <input type="text" id="contactId"/>
    </div>

    <div id="ajaxGetAllUsersServletResponse"></div>
    <div id="ajaxCreateContactServletResponse"></div>
    <div id="ajaxGetUserByIdResponse"></div>

    <script src="http://code.jquery.com/jquery-1.10.2.js"
            type="text/javascript"></script>
    <script src="js/show-all-contacts-ajax.js" type="text/javascript"></script>
    <script src="js/create-show-contact-ajax.js" type="text/javascript"></script>
    <script src="js/show_contact_by_id.js" type="text/javascript"></script>
</body>
</html>
