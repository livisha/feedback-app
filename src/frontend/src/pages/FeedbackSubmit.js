import { Link } from "react-router-dom"

const FeedbackSubmit = () => {
    return (
        <div className="feedback-submit">
            <h1>Thank You For Your Submission!</h1>
            <h3>Your review will help us to improve our facilities. Hope you
                will visit us soon...!</h3>
            <h4><b><Link to="/">Back to the HomePage....</Link></b></h4>
        </div>
    );
}

export default FeedbackSubmit;