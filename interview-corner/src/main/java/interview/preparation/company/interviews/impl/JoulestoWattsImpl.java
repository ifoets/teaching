package interview.preparation.company.interviews.impl;

import interview.preparation.company.interviews.question.IJoulestoWatts;

public class JoulestoWattsImpl implements IJoulestoWatts {

    @Override
    public String transform(String str)
    {
        int count =0;
        char []chars = str.toCharArray();
        for (char aChar : chars) {
            if (aChar == '?')
                count++;
        }
       return transformStr(chars, str.length(), count);
    }
    //a?bb", "a?b?aa", "aa??aa", ???a??b??? -> "aabb", "aabbaa",  "aabbaa", //???a??b???
    @Override
    public String transformStr(char[] chars, int N, int count)
    {
            if(count==0)
                return String.valueOf(chars);
            else {
                for(int i=0;i<N;i++)
                {
                    if(i+1< N && chars[i]==chars[i+1])
                    {
                        if((i+2)<N && chars[i+2]=='?')
                        {
                            if(chars[i]=='a')
                                chars[i+2]='b';
                            else if(chars[i]=='b')
                                chars[i+2]='a';
                            else {
                                chars[i]='a';
                                chars[i+1]='b';
                                chars[i+2]='a';
                            }
                        }
                        if(i-1>=0 && chars[i-1]=='?')
                        {
                            if(chars[i]=='a')
                                chars[i-1]='b';
                            else if(chars[i]=='b')
                                chars[i-1]='a';
                            }
                    }
                    else if(i+1<N && i-1>=0)
                    {
                        if(chars[i-1]==chars[i+1])
                        {
                            if(chars[i-1]=='b')
                                chars[i]='a';
                            else if(chars[i-1]=='a')
                                chars[i]='b';
                            else {
                                chars[i] = 'a';
                                chars[i + 1] = 'b';
                                chars[i + 2] = 'a';
                            }
                        }
                    }
                }
                if(chars[N-1]=='?')
                {
                    if(chars[N-2]=='a')
                        chars[N-1]='b';
                    else chars[N-1] ='b';
                }

            }
        return transform(String.valueOf(chars));
    }

    /*technique build string of length str.length() aabbaabb...series then replace indexed a or b
    and finally check 3 consecutive a or b
     */
    public String convert(String str){
        int l = str.length();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0,j=0;i<l;i+=2,j++)
        {
            if(j%2==0)
            stringBuilder.append("aa");
            else stringBuilder.append("bb");
        }
        if(l%2==1)
            stringBuilder.append("a");
        char[] charsNew = stringBuilder.toString().toCharArray();
        char [] chars = str.toCharArray();
        for(int i=0;i<l;i++)
        {
            if(chars[i]!='?')
                charsNew[i]=chars[i];
        }
        //now check 3 a/b consecutive and replace middle in new String
        for(int i=1;i<l-1;i++)
        {
            if(charsNew[i-1]==charsNew[i] && charsNew[i]==charsNew[i+1])
            {
                if(charsNew[i]=='a')
                    charsNew[i]='b';
                else charsNew[i]='a';
            }
        }
        return new String(charsNew);
    }
}
