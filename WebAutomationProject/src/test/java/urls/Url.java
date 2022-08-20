package urls;

public enum Url {//creating and assigning url value

    BASEURL("https://www.enuygun.com/ucak-bileti/");
    String url;
    Url(String url){

        this.url = url;
    }
    public String getURL() {

        return url;
    }
}