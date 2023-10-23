package interview.preparation.self.asked.company.impl;

import interview.preparation.self.asked.company.question.IJoulestoWatts;

public class JoulestoWattsImpl implements IJoulestoWatts {

    @Override
    public String transform(String str)
    {
        int count =0;
        char []chars = str.toCharArray();
        for(int i=0;i<chars.length;i++)
        {
            if(chars[i]=='?')
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
}
