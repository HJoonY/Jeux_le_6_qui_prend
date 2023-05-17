package fr.an.game.le6quiprend.clientjavafx.model;

import fr.an.game.le6quiprend.clientjavafx.util.concurrent.CallbackHelperTask;
import fr.an.game.le6quiprend.clientjavafx.util.concurrent.CallbacksBuilder;
import fr.an.game.le6quiprend.common.restapi.dto.TestEchoRequestDTO;
import fr.an.game.le6quiprend.common.restapi.dto.TestEchoResponseDTO;
import javafx.application.Platform;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Consumer;

/**
 * javafx model class (single-thread-apartment-model) for Game
 *
 * all remote calls / slow computations should be done in javafx worker thread, then enqueue event when finished
 */
@Slf4j
public class GameModel {

    protected GameHttpClient gameClient;

    protected ExecutorService defaultExecutorService = Executors.newCachedThreadPool();
    // cf also ForkJoinPool.commonPool();

    //---------------------------------------------------------------------------------------------

    public GameModel(GameHttpClient gameClient) {
        this.gameClient = gameClient;
    }

    //---------------------------------------------------------------------------------------------

    public void asyncTextEcho(TestEchoRequestDTO req,
                              CallbacksBuilder<TestEchoResponseDTO> callbacksBuilder) {
        val task = new CallbackHelperTask<TestEchoResponseDTO>(
                () -> gameClient.testEcho(req),
                callbacksBuilder);
        defaultExecutorService.submit(task);
    }

    // TODO add more server api calls here ..
    // TODO add statefull logic for MVC

}
