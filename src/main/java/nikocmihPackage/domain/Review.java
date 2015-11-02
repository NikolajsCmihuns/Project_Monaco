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
    private String creationDate;


    // Constructor for review on place
    public Review(Integer creatorID, Integer placeID, String title, String body) {
        this.creatorID = creatorID;
        this.placeID = placeID;
        this.title = title;
        this.body = body;
    }

    // Constructor for review on route
    public Review(Integer routeID, String title, String body, Integer creatorID) {
        this.routeID = routeID;
        this.title = title;
        this.body = body;
        this.creatorID = creatorID;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Review review = (Review) o;

        if (!creatorID.equals(review.creatorID)) return false;
        if (placeID != null ? !placeID.equals(review.placeID) : review.placeID != null) return false;
        if (routeID != null ? !routeID.equals(review.routeID) : review.routeID != null) return false;
        if (!title.equals(review.title)) return false;
        if (!body.equals(review.body)) return false;
        return !(imageURL != null ? !imageURL.equals(review.imageURL) : review.imageURL != null);

    }

    @Override
    public int hashCode() {
        int result = creatorID.hashCode();
        result = 31 * result + (placeID != null ? placeID.hashCode() : 0);
        result = 31 * result + (routeID != null ? routeID.hashCode() : 0);
        result = 31 * result + title.hashCode();
        result = 31 * result + body.hashCode();
        result = 31 * result + (imageURL != null ? imageURL.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "Review{" +
                "reviewID=" + reviewID +
                "creatorID=" + creatorID +
                ", placeID=" + placeID +
                ", routeID=" + routeID +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }


}
