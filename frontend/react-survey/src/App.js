import { useCallback, useEffect, useState } from "react";

import "survey-core/defaultV2.min.css";
import { StylesManager, Model } from "survey-core";
import { Survey } from "survey-react-ui";

StylesManager.applyTheme("defaultV2");

var json = {
  pages: [
    {
      name: "page1",
      elements: [
        {
          type: "rating",
          name: "nps_score",
          title:
            "How likely are you to recommend Groove to a friend or colleague??",
          isRequired: true,
          rateMin: 0,
          rateMax: 10,
          minRateDescription: "Not at all likely ",
          maxRateDescription: "Extremely likely "
        },
        {
          type: "comment",
          name: "user' comments",
          visible: true,
          title: "Comments please?"
        }
      ]
    }
  ],
  completedHtml: "<h3>Thank you for your feedback</h3>",
  showQuestionNumbers: "off"
};

function App() {
  const survey = new Model(json);
  survey.focusFirstQuestionAutomatic = true;

  const [submition, setSubmition] = useState([]);

  const alertResults = useCallback((sender) => {
    const body = {
      comment: String(sender.data[`user' comments`].replace(/[^\w\s]/gi, '')),
      id: Math.floor(Math.random() * 1000),
      score: Number(sender.data.nps_score)
    };
    console.log(body);
  fetch('http://localhost:8080/submission/createSubmission', {  
    method: "POST",
    mode:'cors',
    headers: {
      "Access-Control-Allow-Origin": '*',
      "Content-Type": "application/json"
    },
    
    body: JSON.stringify(body)
    
  })
    .then((response) => response.json())
    .then((data) => {
      if (data) {
        console.log("Success:", data);
        setSubmition(data);
        alert((data));
      }
    })
    .catch((error) => {
      throw(error)
    });
}, []);

  survey.onComplete.add(alertResults);

  return <Survey model={survey} />;
}

export default App;
