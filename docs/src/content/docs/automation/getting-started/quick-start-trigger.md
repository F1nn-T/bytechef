---
title: Quick Start - Trigger
description: "Learn how to create and configure a workflow with a trigger in ByteChef"
---

In this guide, you will learn how to create a workflow in ByteChef and configure it with a trigger. We will walk you
through the steps to add a trigger, connect it to a Google Calendar component, set up an action using the OpenAI
component, publish the project, create a deployment, and monitor the workflow execution.

**Note**: If you are testing ByteChef locally, be sure to check out our [Working with Triggers](../../../developer-guide/testing-triggers/triggers) guide for detailed instructions.

## Create Workflow

1. Click on the three dots next to the project name where you want to add a workflow.
2. Choose **New Workflow** from the dropdown menu.
3. Provide a label for your workflow. Optionally, add a description to explain its purpose.
4. Click **Save** to create the workflow.

<div style="position:relative;height:0;width:100%;overflow:hidden;z-index:99999;box-sizing:border-box;padding-bottom:calc(53.02672956% + 32px)">
<iframe src="https://www.guidejar.com/embed/c6eZEJIZYA1aoWesXI7v?type=1&controls=on" width="100%" height="100%" style="height:100%;position:absolute;inset:0" allowfullscreen frameborder="0"></iframe>
</div>

## Add Trigger

1. Click on the pencil icon to edit the trigger.
2. Find and select **Google Calendar** component.
3. Select **New or Updated Event** trigger.
4. Go to the **Connection** tab.
5. Click **Create Connection**.
6. Enter a connection name and paste the **Client ID** and **Client Secret** from Google.
7. Click **Next**.
8. Click **Connect**.
9. Select your account.
10. Click **Continue**.
11. Select all and click **Continue**.
12. Click on **Choose Connection** and select the connection you just created.
13. Go to the **Properties** tab.
14. For **Calendar Identifier**, select the calendar you want to monitor.

<div style="position:relative;height:0;width:100%;overflow:hidden;z-index:99999;box-sizing:border-box;padding-bottom:calc(53.02672956% + 32px)">
<iframe src="https://www.guidejar.com/embed/7hcdEZScz1LPEMFqtbiJ?type=1&controls=on" width="100%" height="100%" style="height:100%;position:absolute;inset:0" allowfullscreen frameborder="0"></iframe>
</div>

## Add Action

1. Click on the **+** button to add component.
2. Find and select the **OpenAI** component and choose the **Ask** action.
3. Click on the **OpenAI** component to open its configuration panel.
4. In the **Connection** tab, click **Create Connection**.
5. Enter a connection name and paste the **API Token** from OpenAI.
6. Click **Save**.
7. Click on **Choose Connection** and select the connection you just created.
8. Go to the **Properties** tab.
9. For **Model**, choose the desired model (e.g., `gpt-4`).
10. For **Role**, select the appropriate role (e.g., `user`).
11. For **Content**, enter the prompt text, such as `Desribe this event:`.

<div style="position:relative;height:0;width:100%;overflow:hidden;z-index:99999;box-sizing:border-box;padding-bottom:calc(53.02672956% + 32px)">
<iframe src="https://www.guidejar.com/embed/DJY0kLqoCFX1cci6molN?type=1&controls=on" width="100%" height="100%" style="height:100%;position:absolute;inset:0" allowfullscreen frameborder="0"></iframe>
</div>

## Use Data Pill

1. After clicking on the content field, the Data Pill Panel will open on the left. Use the data pill to insert output
   from a previous component.
2. Click on **Google Calendar** component in Data Pill Panel.
3. Click on **trigger_1**, which is the output of the trigger for the Google Calendar component.
4. Output of Google Calendar trigger is now inserted into the content field.

<div style="position:relative;height:0;width:100%;overflow:hidden;z-index:99999;box-sizing:border-box;padding-bottom:calc(53.02672956% + 32px)">
<iframe src="https://www.guidejar.com/embed/OouHIYrdrN4TIUSyyhGw?type=1&controls=on" width="100%" height="100%" style="height:100%;position:absolute;inset:0" allowfullscreen frameborder="0"></iframe>
</div>

## Publish Project and Create Deployment

1. Click **Publish**.
2. Optionally, provide a description for this published version and click **Publish**.
3. Navigate to the **Project Deployments**.
4. Click **Create Deployment**.
5. Select the project you want to deploy.
6. Choose the published version you want to deploy.
7. Click **Next**.
8. Turn on all workflows you want to include in the deployment.
9. Setup connection for each component.
10. Click **Save**.
11. Enable the deployment. Your workflow will now run whenever a new or updated event is detected in your Google
    Calendar.

<div style="position:relative;height:0;width:100%;overflow:hidden;z-index:99999;box-sizing:border-box;padding-bottom:calc(53.02672956% + 32px)">
<iframe src="https://www.guidejar.com/embed/ua8BPgHqcndU62z7A4QV?type=1&controls=on" width="100%" height="100%" style="height:100%;position:absolute;inset:0" allowfullscreen frameborder="0"></iframe>
</div>

## Monitor Workflow Execution

1. Navigate to the **Workflow Execution History** view. Here you can see the status of your workflow executions.
2. Click on an execution to see the details of each component in the workflow.
3. Review the input and output of the Google Calendar trigger. Click on the **OpenAI** component to see the result of
   the Ask action.
4. Click on the icon to view the entire output.

<div style="position:relative;height:0;width:100%;overflow:hidden;z-index:99999;box-sizing:border-box;padding-bottom:calc(51.63511188% + 32px)">
<iframe src="https://www.guidejar.com/embed/HUIB9dVjnNfEYp0DH60i?type=1&controls=on" width="100%" height="100%" style="height:100%;position:absolute;inset:0" allowfullscreen frameborder="0"></iframe>
</div>

## Additional Instructions

### Create OAuth 2.0 Application

1. Go to the [Google Cloud Console](https://console.cloud.google.com/).
2. Click on the project dropdown in the top navigation bar.
3. Click **New Project**.
4. Enter a project name and click **Create**.
5. Click on the project dropdown again.
6. Select the project you just created.
7. Go to the **APIs & Services**.
8. Go to the **OAuth consent screen**.
9. Click **Get Started**.
10. Enter an App name and add user support email. Click **Next**.
11. Select your Audience and click **Next**.
12. Add email addresses and click **Next**.
13. Agree to the terms and click **Create**.
14. Go to **Data Access**.
15. Click on **Add or Remove Scopes**.
16. Select all necessary scopes.
17. Click **Update**.
18. Click **Save**.
19. Go to the **Clients**.
20. Click on **Create Client**.
21. Click on application type dropdown.
22. Choose **Web application** as the application type.
23. Click on **Add Uri**.
24. Enter a redirect URI, e.g., `https://app.bytechef.io/callback`, `http://127.0.0.1:5173/callback`. Click **Create**.
25. Click on the client you just created.
26. Copy the **Client ID** and **Client Secret**. Use these credentials to create a connection in ByteChef.

<div style="position:relative;height:0;width:100%;overflow:hidden;z-index:99999;box-sizing:border-box;padding-bottom:calc(51.63511188% + 32px)">
<iframe src="https://www.guidejar.com/embed/fec74020-26bb-43dd-814c-f8b907f6f45b?type=1&controls=on" width="100%" height="100%" style="height:100%;position:absolute;inset:0" allowfullscreen frameborder="0"></iframe>
</div>

### Enable Google Calendar API

1. In the [Google Cloud Console](https://console.cloud.google.com/), select your project.
2. Go to the **APIs & Services**.
3. Click on **ENABLE APIS AND SERVICES**.
4. Search for "calendar" in the search bar.
5. Click on **Google Calendar API**.
6. Click **Enable**.

<div style="position:relative;height:0;width:100%;overflow:hidden;z-index:99999;box-sizing:border-box;padding-bottom:calc(50.05219207% + 32px)">
<iframe src="https://www.guidejar.com/embed/c1fe8158-a72f-45ed-942e-c1bab5802afa?type=1&controls=on" width="100%" height="100%" style="height:100%;position:absolute;inset:0" allowfullscreen frameborder="0"></iframe>
</div>

### Create OpenAI Connection

1. Go to the [OpenAI API](https://platform.openai.com/settings/organization/general).
2. In the left sidebar, click on **API Keys**.
3. Click **Create new secret key**.
4. Enter a name and select the project for the key and click **Create secret key**.
5. Copy the API key and use it to create a connection in ByteChef.

<div style="position:relative;height:0;width:100%;overflow:hidden;z-index:99999;box-sizing:border-box;padding-bottom:calc(50.05219207% + 32px)">
<iframe src="https://www.guidejar.com/embed/coPV2tDXMJmcpVHubS0J?type=1&controls=on" width="100%" height="100%" style="height:100%;position:absolute;inset:0" allowfullscreen frameborder="0"></iframe>
</div>
