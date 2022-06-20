package com.psol.algorithm.kakao_02;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution_ {
    public int checkPrev(int index, int[] colors) {
        if(colors[index - 2] == 0) {
            return 0;
        }

        return colors[index - 2] == 1 ? 2 : 1;
    }

    public int checkNext(int index, int[] colors) {
        if(colors[index + 2] == 0) {
            return 0;
        }

        return colors[index + 2] == 1 ? 2 : 1;
    }

    public int[] solution(int[] black_caps) {
        int[] colors = new int[black_caps.length];

        for (int i = 0; i < black_caps.length; i++) {
            if (i == 0) {
                colors[i + 1] = black_caps[i] == 0 ? 2 : 1;
                continue;
            }

            if (i == black_caps.length - 1) {
                colors[i - 1] = black_caps[i] == 0 ? 2 : 1;
                continue;
            }

            if (black_caps[i] == 2) {
                colors[i - 1] = 1;
                colors[i + 1] = 1;
            }

            if (black_caps[i] == 0) {
                colors[i - 1] = 2;
                colors[i + 1] = 2;
            }
        }


        Set<Integer> indexSet = new HashSet<>();

        for (int i = 0; i < colors.length; i++) {
            if(colors[i] == 0) {
                indexSet.add(i);
            }
        }

        while (indexSet.size() > 0) {
            int prevCount = indexSet.size();
            List<Integer> removeList = new ArrayList<>();

            for(int i : indexSet) {
                if (i == 0) {
                    colors[i] = checkNext(i, colors);

                    if(colors[i] != 0) {
                        removeList.add(i);
                    }
                    continue;
                }

                if(i == colors.length - 1) {
                    colors[i] = checkPrev(i, colors);

                    if(colors[i] != 0) {
                        removeList.add(i);
                    }
                    continue;
                }

                colors[i] = checkPrev(i, colors);

                if(colors[i] == 0) {
                    colors[i] = checkNext(i, colors);
                }

                if(colors[i] != 0) {
                    removeList.add(i);
                }
            }

            if (removeList.size() == 0) {
                break;
            }

            indexSet.removeAll(removeList);
        }

        return colors;
    }
}
