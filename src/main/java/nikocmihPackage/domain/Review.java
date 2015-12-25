package nikocmihPackage.domain;

/**
 * Created by Nikolajs Cmihuns on 19/10/2015.
 */
public class Review {

    private Integer reviewID; //is set in DB table AUTOINCREMENTAL
    private Integer creatorID;
    private Integer placeID;
    private Integer routeID;
    private String title;
    private String body;
    private String imageURL;
    private String creationDate; //is set in DB table


    // Default constructor
    public Review(){

    }


    // Getters

    public Integer getReviewID() { return reviewID; }

    public Integer getCreatorID() { return creatorID; }

    public Integer getPlaceID() { return placeID; }

    public String getTitle() { return title; }

    public Integer getRouteID() { return routeID; }

    public String getBody() { return body; }

    public String getImageURL() { return imageURL; }

    public String getCreationDate() { return creationDate; }


    //Setters


    public void setReviewID(Integer reviewID) { this.reviewID = reviewID; }

    public void setCreatorID(Integer creatorID) { this.creatorID = creatorID; }

    public void setPlaceID(Integer placeID) { this.placeID = placeID; }

    public void setRouteID(Integer routeID) { this.routeID = routeID; }

    public void setTitle(String title) { this.title = title; }

    public void setBody(String body) { this.body = body; }

    public void setImageURL(String imageURL) { this.imageURL = imageURL; }

    public void setCreationDate(String creationDate) { this.creationDate = creationDate; }


    @Override
    public String toString() {
        return "Review{" +
                "reviewID=" + reviewID +
                ", creatorID=" + creatorID +
                ", placeID=" + placeID +
                ", routeID=" + routeID +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", creationDate='" + creationDate + '\'' +
                '}';
    }
}
