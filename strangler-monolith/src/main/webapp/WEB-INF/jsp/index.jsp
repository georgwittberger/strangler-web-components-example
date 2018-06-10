<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <link rel="stylesheet" href="<c:url value="/webjars/bootstrap/4.0.0/css/bootstrap.min.css" />" />
    <title>Strangler Web Components Example</title>
  </head>
  <body class="p-3">
    <div class="container">
      <h1>Strangler Web Components Example</h1>

      <div class="row mt-3">
        <div class="col-sm">
          <div class="card">
            <div class="card-body">
              <h2 class="card-title">Monolith Content</h2>
              <p class="card-text">This main page is provided by the monolith.
                 It includes content rendered directly into the document, like the following message:</p>
              <p class="card-text text-primary">${message}</p>
            </div>
          </div>
        </div>
        <div class="col-sm">
          <div class="card">
            <div class="card-body">
              <h2 class="card-title">Monolith Form</h2>
              <p class="card-text">Enter some user data to store them in the monolith's session.</p>
              <form:form method="POST" action="/user-data" modelAttribute="userData">
                <div class="form-group">
                  <form:label path="name">Name</form:label>
                  <form:input path="name" class="form-control" />
                </div>
                <div class="form-group">
                  <form:label path="email">E-Mail</form:label>
                  <form:input path="email" class="form-control" />
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
              </form:form>
            </div>
          </div>
        </div>
      </div>

      <div class="row mt-3">
        <div class="col-sm">
          <!-- Message Component provided by the microservice -->
          <div id="strangler-message-component"
               data-server-base-url="http://localhost:10081/strangler-microservice/v1">
            <p>Loading message component...</p>
          </div>
        </div>
        <div class="col-sm">
          <!-- Greeting Component provided by the microservice -->
          <div id="strangler-greeting-component"
               data-server-base-url="http://localhost:10081/strangler-microservice/v1"
               data-monolith-session-cookie-name="MONOSID"
               data-monolith-session-cookie-value="${sessionId}">
            <p>Loading greeting component...</p>
          </div>
        </div>
      </div>
    </div>

    <script>
      // Non-blocking, deferred loading of the web components bundle
      var scriptElement = document.createElement('script');
      scriptElement.setAttribute('src', 'http://localhost:10081/strangler-microservice/v1/js/strangler-web-components-1.0.0.js');
      document.body.appendChild(scriptElement);
    </script>
  </body>
</html>
