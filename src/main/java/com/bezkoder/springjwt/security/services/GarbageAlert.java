package com.bezkoder.springjwt.security.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.models.GarbagePt;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GarbageAlert {

    @Autowired
    private EmailSender emailSender;

    public void sendsAlert(GarbagePt garbagePt){
        
        emailSender.send(garbagePt.getUser().getEmail(), buildTrashFullEmail(garbagePt.getUser().getFirstname() + 
            garbagePt.getUser().getLastname(), garbagePt.getWasteLevels()));
        
    }
    
    public String buildTrashFullEmail(String recipientName, String percentageFull) {
        return "<div style=\"font-family: Helvetica, Arial, sans-serif; font-size: 16px; margin: 0; color: #0b0c0c\">\n" +
                "\n" +
                "  <table role=\"presentation\" width=\"100%\" style=\"border-collapse: collapse; min-width: 100%; width: 100%!important\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                "    <tbody><tr>\n" +
                "      <td width=\"100%\" height=\"53\" bgcolor=\"#0b0c0c\">\n" +
                "        \n" +
                "        <table role=\"presentation\" width=\"100%\" style=\"border-collapse: collapse; max-width: 580px\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\">\n" +
                "          <tbody><tr>\n" +
                "            <td width=\"70\" bgcolor=\"#0b0c0c\" valign=\"middle\">\n" +
                "                <table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse: collapse\">\n" +
                "                  <tbody><tr>\n" +
                "                    <td style=\"padding-left: 10px\">\n" +
                "                  \n" +
                "                    </td>\n" +
                "                    <td style=\"font-size: 28px; line-height: 1.315789474; Margin-top: 4px; padding-left: 10px\">\n" +
                "                      <span style=\"font-family: Helvetica, Arial, sans-serif; font-weight: 700; color: #ffffff; text-decoration: none; vertical-align: top; display: inline-block\">Trash Full Alert</span>\n" +
                "                    </td>\n" +
                "                  </tr>\n" +
                "                </tbody></table>\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "        </tbody></table>\n" +
                "        \n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody></table>\n" +
                "  <table role=\"presentation\" class=\"m_-6186904992287805515content\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse: collapse; max-width: 580px; width: 100%!important\" width=\"100%\">\n" +
                "    <tbody><tr>\n" +
                "      <td width=\"10\" height=\"10\" valign=\"middle\"></td>\n" +
                "      <td>\n" +
                "        \n" +
                "                <table role=\"presentation\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse: collapse\">\n" +
                "                  <tbody><tr>\n" +
                "                    <td bgcolor=\"#FF0000\" width=\"100%\" height=\"10\"></td>\n" +
                "                  </tr>\n" +
                "                </tbody></table>\n" +
                "        \n" +
                "      </td>\n" +
                "      <td width=\"10\" valign=\"middle\" height=\"10\"></td>\n" +
                "    </tr>\n" +
                "  </tbody></table>\n" +
                "\n" +
                "\n" +
                "\n" +
                "  <table role=\"presentation\" class=\"m_-6186904992287805515content\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse: collapse; max-width: 580px; width: 100%!important\" width=\"100%\">\n" +
                "    <tbody><tr>\n" +
                "      <td height=\"30\"><br></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <td width=\"10\" valign=\"middle\"><br></td>\n" +
                "      <td style=\"font-family: Helvetica, Arial, sans-serif; font-size: 19px; line-height: 1.315789474; max-width: 560px\">\n" +
                "        \n" +
                "            <p style=\"Margin: 0 0 20px 0; font-size: 19px; line-height: 25px; color: #0b0c0c\">Hi " + recipientName + ",</p>\n" +
                "            <p style=\"Margin: 0 0 20px 0; font-size: 19px; line-height: 25px; color: #0b0c0c\">Your trash bin is almost full. It's currently at " + percentageFull + "% capacity. Please empty it soon to avoid any inconvenience.</p>\n" +
                "            <p>Thank you!</p>\n" +
                "        \n" +
                "      </td>\n" +
                "      <td width=\"10\" valign=\"middle\"><br></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <td height=\"30\"><br></td>\n" +
                "    </tr>\n" +
                "  </tbody></table><div class=\"yj6qo\"></div><div class=\"adL\">\n" +
                "\n" +
                "</div></div>";
    }
    

}
