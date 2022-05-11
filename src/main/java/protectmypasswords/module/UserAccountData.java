package protectmypasswords.module;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsonable;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

public class UserAccountData implements Jsonable, java.io.Serializable{

        private String masterPass;
        private List<?> ojb;

        public UserAccountData(String masterPass, List<?> ojb) {
            this.masterPass = masterPass;
            this.ojb = ojb;
        }

        public String getMasterPass() {
                return masterPass;
            }

        public List<?> getOjb() {
            return ojb;
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
        json.put(this.getMasterPass(), this.getOjb());
        json.toJson(writer);
        }

        public JsonObject toJsonObj() throws IOException {

                final JsonObject json = new JsonObject();
                json.put(this.getMasterPass(), this.getOjb());
                return json;
        }
}