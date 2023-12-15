<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>My Diary - User Home</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
      background: linear-gradient(to right, #f06, #9f6);
    }

    header {
        background: linear-gradient(to right, #f06, #9f6);
      color: white;
      padding: 10px;
      text-align: center;
      display: flex;
      justify-content: space-between;
      align-items: center;
    }

    section {
      margin: 20px;
      padding: 20px;
      background-color: #fff;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    .entry {
      display: flex;
      justify-content: space-between;
      align-items: center;
      padding: 10px;
      margin-bottom: 10px;
      border: 1px solid #ccc;
      background-color: #f0f0f0; /* Light gray entry background color */
    }

    .entry-date {
      font-weight: bold;
      color: #333;
    }

    button {
      padding: 8px;
      background-color: #4caf50; /* Green button color */
      color: white;
      border: none;
      cursor: pointer;
    }

    button:hover {
      background-color: #45a049; /* Darker green on hover */
    }

    .add-entry-btn {
      margin-bottom: 20px;
    }

    .sign-out-btn {
      background-color: #d32f2f; /* Red button color for sign out */
    }

    .sign-out-btn:hover {
      background-color: #b71c1c; /* Darker red on hover */
    }

  </style>
</head>
<body>

  <header>
    <p>Welcome, <span id="username">${user.username}</span>!</p>
    <h1>My Diary</h1>
    <button class="sign-out-btn"><a href="./signout" style="color: white;">Sign Out</a></button>
	
  </header>

  <section>
    <h2>Entries</h2>

    <button class="add-entry-btn"><a href="./showAddEntryPage" style="color: white;">Add Entry</a></button>

    <c:if test="${entrieslist.size()==0}">
      <tr>
        <td style="font-size:20px;color:green;text-align:center" colspan="4">User not added any Diary entries till now.</td>
      </tr>
    </c:if>
   

   <c:forEach items="${entrieslist}" var="e">
    <div class="entry">
      <span class="entry-date"><fmt:formatDate value="${e.entrydate}" pattern="dd/MM/yyyy"/></span>
      <button><a href="./viewentry?id=${e.id}" style="color: white;">View</a></button>
      <button><a href="./updateentry?id=${e.id}" style="color: white;">Update</a></button>
      <button><a href="./deleteentry?id=${e.id}"style="color: white;">Delete</a></button>
    </div>
   </c:forEach>

    <!-- More entries can be added here -->

  </section>

</body>
</html>
