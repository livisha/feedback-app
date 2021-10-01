import {useState} from "react";
import { useHistory, useParams } from "react-router-dom";


const FeedbackForm = () => {

    const { pnr } = useParams();
    const { uuid } = useParams();



    const [userEmail, setUserEmail] = useState("");
    const [userName, setUserName] = useState("");
    const [userPhone, setUserPhone] = useState("");
    const [userAirways, setUserAirways] = useState("");
    const [userSource, setUserSource] = useState("");    
    const [userDestination, setUserDestination] = useState("");
    const [userDate, setUserDate] = useState("");
    const [flightId, setFlightId] = useState("");
    const [message, setMessage] = useState("");

    //const [isPending, setIsPending] = useState(false);
    const history = useHistory();


    const handleSubmit = (e) => {
        e.preventDefault();
        const feedbackRequest = { userEmail, userName, userPhone, userAirways, userSource, userDestination, userDate, flightId, message };

        fetch(`http://localhost:8081/sendFeedback/pnr=${pnr}/uuid=${uuid}`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(feedbackRequest),
        }).then(() => {
            history.push("/feedbackSubmit");
        });
    };

    console.log("PNR := "+pnr);

    return (
        <div className="feedbackForm">
            <h2 className="heading">FeedBack</h2>
            <div className="listitems">
            <form onSubmit={handleSubmit}>

                <label><b>Email :</b></label>
                <input
                    placeholder="Enter your Email"
                    id = "Text"
                    type="text"
                    required
                    value={userEmail}
                    onChange={(e) => setUserEmail(e.target.value)}
                />
                <br />

                <label><b>Name :</b></label>
                <input
                    placeholder="Enter your Name"
                    id = "Text"
                    type="text"
                    required
                    value={userName}
                    onChange={(e) => setUserName(e.target.value)}
                />
                <br />

                <label><b>Phone:</b></label>
                <input
                    placeholder="Enter your Phone number"
                    id = "Text"
                    type="text"
                    required
                    value={userPhone}
                    onChange={(e) => setUserPhone(e.target.value)}
                />
                <br />


                <label><b>Airways :</b></label>
                <input
                    placeholder="Enter your name of airway"
                    id = "Text"
                    type="text"
                    required
                    value={userAirways}
                    onChange={(e) => setUserAirways(e.target.value)}
                />
                <br />

                <label><b>Source :</b></label>
                <input
                    placeholder="Enter your source place"
                    id = "Text"
                    type="text"
                    required
                    value={userSource}
                    onChange={(e) => setUserSource(e.target.value)}
                />
                <br />

                <label><b>Destination :</b></label>
                <input
                    placeholder="Enter your Destination place"
                    id = "Text"
                    type="text"
                    required
                    value={userDestination}
                    onChange={(e) => setUserDestination(e.target.value)}
                />
                <br />

                <label><b>Date :</b></label>
                <input
                    placeholder="Enter Date of Travel"
                    id = "Text"
                    type="text"
                    required
                    value={userDate}
                    onChange={(e) => setUserDate(e.target.value)}
                />
                <br />


                <label><b>Flight-Id :</b></label>
                <input
                    placeholder="Enter Flight ID"
                    id = "Text"
                    type="text"
                    required
                    value={flightId}
                    onChange={(e) => setFlightId(e.target.value)}
                />
                <br />

                <label><b>Message :</b></label>
                <input
                    placeholder="Any Suggestion"
                    id = "Text"
                    type="text"
                    value={message}
                    onChange={(e) => setMessage(e.target.value)}
                />
                <br />

                <button className="button">
                <div className="pattern">
                    <div className="target inner bg1"></div>
                </div>
                <div className="text">Send Feedback</div>
                </button>
            </form>
            </div>
        </div>
    );


};

export default FeedbackForm;