const FeedbackList = (props) => {

    const feedbacks = props.feedbacks;

    return (
        <div className="feedback-list">
            { feedbacks.map(
                (feedback) => (
                    <div className="feedback-preview">
                        <h3>{ feedback.userEmail }</h3>
                        <h3>{ feedback.flightId }</h3>
                        <h2>{ feedback.message }</h2>
                        <h3>{ feedback.createdAt}</h3>
                    </div>
                )
            ) }
        </div>
    );
}



export default FeedbackList;