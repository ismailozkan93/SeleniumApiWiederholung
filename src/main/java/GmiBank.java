import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class GmiBank {

    public static List<GmiBank> getLocations(InputStream inputStream) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            TypeReference<List<GmiBank>> typeReference = new TypeReference<>() {};
            return objectMapper.readValue(inputStream, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "ClassPojo [id = "+id+", " +
                "name = "+name+", states = "+states+"]";
    }

    private String id;
    private String name;
    private String states;


    public GmiBank() {
    }

    public GmiBank( String id, String name, String states) {
        this.id = id;
        this.name = name;
        this.states= states;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getStates ()
    {
        return states;
    }

    public void setStates (String states)
    {
        this.states = states;
    }

}
