$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/Test.feature");
formatter.feature({
  "name": "Test",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Test scenario",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I have valid authentication token to access api",
  "keyword": "Given "
});
formatter.match({
  "location": "TestSteps.thisIsTest()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I fetch all tasks",
  "keyword": "When "
});
formatter.match({
  "location": "TestSteps.useTheToken()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should get the status code 200",
  "keyword": "Then "
});
formatter.match({
  "location": "CommonSteps.iShouldGetTheStatusCode(Integer)"
});
formatter.result({
  "status": "passed"
});
});