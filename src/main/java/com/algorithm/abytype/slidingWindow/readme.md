滑动窗口框架:
HashMap<Character, Integer> window = new HashMap<>();
HashMap<Character, Integer> need = new HashMap<>();

    public void template(String s, String t) {
        int left = 0;
        int right = 0;
        int valid = 0;
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        while (right < s.length()) {
            char c = s.charAt(right);
            //右边窗口移动
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }
            //左边收缩--不同的题这里的收缩条件会不一样
            while (need.size() == valid) {
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d))) {
                        valid--;
                    }
                    window.put(c, window.getOrDefault(d, 0) - 1);

                }
            }
        }
    }