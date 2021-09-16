package group.rxcloud.rmg.email.core.domain;

/**
 * The Email Detail Info.
 */
public class EmailDetail {

    /**
     * The target email address.
     */
    private String email;

    /**
     * The email title.
     */
    private String title;

    /**
     * The email subTitle.
     */
    private String subTitle;

    /**
     * The email html content.
     */
    private String content;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
