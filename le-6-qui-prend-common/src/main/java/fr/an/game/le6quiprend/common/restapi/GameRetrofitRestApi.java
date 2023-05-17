package fr.an.game.le6quiprend.common.restapi;

import fr.an.game.le6quiprend.common.restapi.dto.TestEchoRequestDTO;
import fr.an.game.le6quiprend.common.restapi.dto.TestEchoResponseDTO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;

/**
 * interface for Game http client, using Retrofit library
 * (cf https://github.com/square/retrofit)
 */
public interface GameRetrofitRestApi {

    static final String BASE = "/api/le-6-qui-prend";

    @GET(BASE + "/health-check")
    public Call<Void> healthCheck();

    /**
     * to check you can send-request/receive-response
     */
    @PUT(BASE + "/test-echo")
    public Call<TestEchoResponseDTO> testEcho(@Body TestEchoRequestDTO req);

}
