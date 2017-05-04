public class BowlingGame {

    public int getBowlingScore(String bowlingCode) {
        bowlingCode=bowlingCode.replace("-","0");
        String[] blocks=bowlingCode.split("\\|");

        if(blocks[9].charAt(0)=='X' ||blocks[9].charAt(1)=='/')
            blocks[10]=blocks[11];

        int score=0;
        for (int i=0;i<10;++i) {
            if(blocks[i].charAt(0)=='X'){
                score+=10;
                if(blocks[i+1].charAt(0)=='X'){
                    score+=10;
                    if(blocks[i+2].charAt(0)=='X')
                        score+=10;
                    else
                        score+=(blocks[i+2].charAt(0)-'0');
                }else{
                    if(blocks[i+1].charAt(1)=='/')
                        score += 10;
                    else {
                        score += (blocks[i + 1].charAt(0) - '0');
                        score+=(blocks[i+1].charAt(1)-'0');
                    }
                }
            }else{
                if(blocks[i].charAt(1)=='/'){
                    score+=10;
                    if(blocks[i+1].charAt(0)=='X')
                        score+=10;
                    else
                        score += (blocks[i + 1].charAt(0) - '0');
                }else{
                    score += (blocks[i].charAt(0) - '0');
                    score += (blocks[i].charAt(1) - '0');
                }
            }
        }
        return score;
    }
}
