package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;

// 숫자 야구 게임 관리
public class NumberBaseballGameServer {

    private static final int GAME_NUMBER_RANGE_MAX = 9;
    private static final int GAME_NUMBER_RANGE_MIN = 1;
    private static final int COUNT_GAME_NUMBER = 3;

    public void run() {
        // 게임의 흐름과 순서 관리
    }

    public List<Integer> makeNewGameNumber() {
        List<Integer> gameNumberList = new ArrayList<Integer>(COUNT_GAME_NUMBER);
        while (gameNumberList.size() < COUNT_GAME_NUMBER) {
            int randomNumber = pickNumberInRange(GAME_NUMBER_RANGE_MIN, GAME_NUMBER_RANGE_MAX);
            if (gameNumberList.contains(randomNumber)) {
                continue;
            }
            gameNumberList.add(randomNumber);
        }
        return gameNumberList;
    }

    public NumberBaseballGameJudgedResultDto judgeInputNumber(int inputNumber,
        List<Integer> gameNumberList) {
        int countBalls = 0, countStrikes = 0;

        String[] playerNumberString = Integer.toString(inputNumber).split("");

        for (int index = 0; index < playerNumberString.length; ++index) {
            int parsed = Integer.parseInt(playerNumberString[index]);
            int matchIndex = gameNumberList.indexOf(parsed);
            if (matchIndex == -1) {
                continue;
            }
            if (matchIndex == index) {
                ++countStrikes;
                continue;
            }
            ++countBalls;
        }

        NumberBaseballGameJudgedResultDto judgedResultDto = new NumberBaseballGameJudgedResultDto();
        judgedResultDto.countBalls = countBalls;
        judgedResultDto.countStrikes = countStrikes;
        return judgedResultDto;
    }
}
