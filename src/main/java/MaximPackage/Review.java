package MaximPackage;

/**
 * Created by maksimspuskels on 18/10/15.
 */
public class Review {
    private Integer reviewID;
    private String  title;
    private String  body;
//    private yetUndefined creationDate;
    private Integer creatorID;
    private Integer relatedRouteID;
    private Integer relatedPlaceID;
    private String imageUrl;

//    Missing route or place id, but most probably should use inheritance here too
    public Review(Integer reviewID, String title, String body, Integer creatorID, String imageUrl) {
        this.reviewID = reviewID;
        this.title = title;
        this.body = body;
        this.creatorID = creatorID;
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "-== REVIEW ==-" + "\n" + reviewID + "\n" + title + "\n" + body + "\n" + creatorID + "\n" + imageUrl + "\n" + "-========-";
    }
}
