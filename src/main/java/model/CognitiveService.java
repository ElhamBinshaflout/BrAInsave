package model;

import org.springframework.stereotype.Service;
import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.http.impl.client.HttpClients;

@Service
public class CognitiveService {
	// Replace <Subscription Key> with your valid subscription key.
	 private static final String subscriptionKey = "1ab191ee662f406988891bb5b379833b";

	 // NOTE: You must use the same region in your REST call as you used to
	 // obtain your subscription keys. For example, if you obtained your
	 // subscription keys from westus, replace "westcentralus" in the URL
	 // below with "westus".
	 //
	 // Free trial subscription keys are generated in the westcentralus region. If you
	 // use a free trial subscription key, you shouldn't need to change this region.
	 private static final String uriBase =
	     "https://westeurope.api.cognitive.microsoft.com/face/v1.0/detect";

	 private static final String faceAttributes =
	     "age,gender,headPose,smile,facialHair,glasses,emotion,hair,makeup,occlusion,accessories,blur,exposure,noise";

	 public String faceDetection(String imgURL)
	 {
		 String imageWithFaces = "{\"url\":\"" + imgURL + "\"}";
	     HttpClient httpclient = HttpClientBuilder.create().build();

	     try
	     {
	         URIBuilder builder = new URIBuilder(uriBase);

	         // Request parameters. All of them are optional.
	         builder.setParameter("returnFaceId", "true");
	         builder.setParameter("returnFaceLandmarks", "false");
	         builder.setParameter("returnFaceAttributes", faceAttributes);

	         // Prepare the URI for the REST API call.
	         URI uri = builder.build();
	         HttpPost request = new HttpPost(uri);

	         // Request headers.
	         request.setHeader("Content-Type", "application/json");
	         request.setHeader("Ocp-Apim-Subscription-Key", subscriptionKey);

	         // Request body.
	         StringEntity reqEntity = new StringEntity(imageWithFaces);
	         request.setEntity(reqEntity);

	         // Execute the REST API call and get the response entity.
	         HttpResponse response = httpclient.execute(request);
	         HttpEntity entity = response.getEntity();

	         if (entity != null)
	         {
	             // Format and display the JSON response.
	             System.out.println("REST Response:\n");

	             String jsonString = EntityUtils.toString(entity).trim();
	             return jsonString;
	         }
	     }
	     catch (Exception e)
	     {
	         System.out.println(e.getMessage());
	     }
		 return null;
	 }

     public static void main(String[] args) 
     {
         HttpClient httpclient = HttpClients.createDefault();

         try
         {
             URIBuilder builder = new URIBuilder("https://westus.api.cognitive.microsoft.com/face/v1.0/findsimilars");


             URI uri = builder.build();
             HttpPost request = new HttpPost(uri);
             request.setHeader("Content-Type", "application/json");
             request.setHeader("Ocp-Apim-Subscription-Key", "{subscription key}");


             // Request body
             StringEntity reqEntity = new StringEntity("{body}");
             request.setEntity(reqEntity);

             HttpResponse response = httpclient.execute(request);
             HttpEntity entity = response.getEntity();

             if (entity != null) 
             {
                 System.out.println(EntityUtils.toString(entity));
             }
         }
         catch (Exception e)
         {
             System.out.println(e.getMessage());
         }
     }
}