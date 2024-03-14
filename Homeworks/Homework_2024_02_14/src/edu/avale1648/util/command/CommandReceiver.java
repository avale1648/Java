package edu.avale1648.util.command;

import edu.avale1648.lang.UnwrapFailureException;
import edu.avale1648.util.result.orig.Result;


public class CommandReceiver {
    public void executeOrigResult() {
        edu.avale1648.util.result.orig.Result<Integer, String> ok = Result.ok(100);
        
        System.out.format("Is ok: %s\n", ok.isOk());
        System.out.format("Is error: %s\n", ok.isError());

        try{
            System.out.format("Unwrap: %s\n", ok.unwrap());
        }catch (UnwrapFailureException ex){
            System.out.format("Unwrap failed with exception: %s\n", ex.getMessage());
        }

        System.out.format("Ok or default: %s\n", ok.okOrDefault(1));
        System.out.format("Err or default: %s\n", ok.errOrDefault("Default error"));

        edu.avale1648.util.result.orig.Result<Integer, String> err = Result.err("Execution failure");
        
        System.out.format("Is ok: %s\n", ok.isOk());
        System.out.format("Is error: %s\n", ok.isError());

        try{
            System.out.format("Unwrap: %s\n", ok.unwrap());
        }catch (UnwrapFailureException ex){
            System.out.format("Unwrap failed with exception: %s\n", ex.getMessage());
        }

        System.out.format("Ok or default: %s\n", err.okOrDefault(1));
        System.out.format("Err or default: %s\n", err.errOrDefault("Default error"));
    }

    public void executeAltResult() {
            edu.avale1648.util.result.alt.Result<Integer, String> ok = edu.avale1648.util.result.alt.Result.ok(100);
            edu.avale1648.util.result.alt.Result<Integer, String> err = edu.avale1648.util.result.alt.Result.err("Execution failure");

            edu.avale1648.util.result.alt.Result.processResult(ok);
            edu.avale1648.util.result.alt.Result.processResult(err);

            try{
                System.out.format("Unwrap: %s\n", ok.unwrap());
            }
            catch(UnwrapFailureException ex){
                System.out.format("Unwrap failed with error: %s\n", ex.getMessage());
            }
    }
}
