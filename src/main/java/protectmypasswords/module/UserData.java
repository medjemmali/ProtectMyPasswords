package protectmypasswords.module;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsonable;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public class UserData implements Jsonable, java.io.Serializable{

    private String addressUrl;
    private String userName;
    private String password;

    public UserData(String addressUrl, String userName, String password) {
        this.addressUrl = addressUrl;
        this.userName = userName;
        this.password = password;


    }

    public String getAddressUrl() {
        return addressUrl;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toJson() {
        final StringWriter writable = new StringWriter();
        try {
            this.toJson(writable);
        } catch (final IOException e) {
        }
        return writable.toString();
    }

    @Override
    public void toJson(Writer writer) throws IOException {

        final JsonObject json = new JsonObject();
        json.put("addressUrl", this.getAddressUrl());
        json.put("userName", this.getUserName());
        json.put("password", this.getPassword());
        json.toJson(writer);
    }

    public JsonObject toJsonObj() throws IOException {

        final JsonObject json = new JsonObject();
        json.put("addressUrl", this.getAddressUrl());
        json.put("userName", this.getUserName());
        json.put("password", this.getPassword());
        return json;
    }
}