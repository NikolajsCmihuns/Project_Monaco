package nikocmihPackage.domain;

/**
 * Created by Nikolajs Cmihuns on 12/15/2015.
 */
public class ReviewBuilder {

    private Integer reviewID; //is set in DB table AUTOINCREMENTAL
    private Integer creatorID;
    private Integer placeID;
    private Integer routeID;
    private String title;
    private String body;
    private String imageURL;
    private String creationDate; //is set in DB table

    private ReviewBuilder() {
        // private constructor, to be not able to call it outside the class
    }

    public static ReviewBuilder createReview(){
        return new ReviewBuilder();
    }

    public ReviewBuilder withReviewID(Integer reviewID){
        this.reviewID = reviewID;
        return this;
    }

    public ReviewBuilder withCreatorID(Integer creatorID){
        this.creatorID = creatorID;
        return this;
    }

    public ReviewBuilder withPlaceID(Integer placeID){
        this.placeID = placeID;
        return this;
    }

    public ReviewBuilder withRouteID(Integer routeID){
        this.routeID = routeID;
        return this;
    }

    public ReviewBuilder withTitle(String title){
        this.title = title;
        return this;
    }

    public ReviewBuilder withBody(String body){
        this.body = body;
        return this;
    }

    public ReviewBuilder withCreationDate(String creationDate){
        this.creationDate = creationDate;
        return this;
    }

    public ReviewBuilder withImageURL(String imageURL){
        this.imageURL = imageURL;
        return this;
    }




    public Review build() {
        Review review = new Review();
        review.setReviewID(reviewID);
        review.setCreatorID(creatorID);
        review.setRouteID(routeID);
        review.setTitle(title);
        review.setBody(body);
        review.setCreationDate(creationDate);
        review.setImageURL(imageURL);
        return review;
    }


}
