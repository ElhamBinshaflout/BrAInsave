package org.ucl.brainsave.model;

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
	 private static final String subscriptionKey = "1ab191ee662f406988891bb5b379833b";

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
	         builder.setParameter("returnFaceId", "true");
	         builder.setParameter("returnFaceLandmarks", "false");
	         builder.setParameter("returnFaceAttributes", faceAttributes);

	         // Prepare the URI for the REST API call.
	         URI uri = builder.build();
	         HttpPost request = new HttpPost(uri);

	         request.setHeader("Content-Type", "application/json");
	         request.setHeader("Ocp-Apim-Subscription-Key", subscriptionKey);
	         StringEntity reqEntity = new StringEntity(imageWithFaces);
	         request.setEntity(reqEntity);

	         // Execute the REST API call and get the response entity.
	         HttpResponse response = httpclient.execute(request);
	         HttpEntity entity = response.getEntity();

	         if (entity != null)
	         {
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
}