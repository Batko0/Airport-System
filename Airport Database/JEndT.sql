PGDMP     :    !                y            JEndT    13.0    13.0 3                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    26433    JEndT    DATABASE     h   CREATE DATABASE "JEndT" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Russian_Kazakhstan.1251';
    DROP DATABASE "JEndT";
                postgres    false            �            1259    26434    aircraft    TABLE     �   CREATE TABLE public.aircraft (
    aircraft_id character(12) NOT NULL,
    model character(12) NOT NULL,
    capacity integer NOT NULL
);
    DROP TABLE public.aircraft;
       public         heap    postgres    false            �            1259    26437    arrival    TABLE     �   CREATE TABLE public.arrival (
    arrival_to text NOT NULL,
    date date,
    arrival_time time without time zone NOT NULL,
    aircraft_id character(12),
    flight_id numeric(12,0)
);
    DROP TABLE public.arrival;
       public         heap    postgres    false            �            1259    26440    captain    TABLE     �   CREATE TABLE public.captain (
    cap_id numeric(12,0) NOT NULL,
    name character(12) NOT NULL,
    surname character(12) NOT NULL,
    hired_date date NOT NULL,
    salary numeric(12,0) NOT NULL
);
    DROP TABLE public.captain;
       public         heap    postgres    false            �            1259    26443    cargo_service    TABLE     �   CREATE TABLE public.cargo_service (
    type character(30) NOT NULL,
    weight integer NOT NULL,
    packing_method character(30) NOT NULL,
    price numeric(12,0) NOT NULL,
    flight_id numeric(12,0),
    cargo_id numeric(12,0) NOT NULL
);
 !   DROP TABLE public.cargo_service;
       public         heap    postgres    false            �            1259    26446    charter_services    TABLE     �   CREATE TABLE public.charter_services (
    company character(20) NOT NULL,
    number_of_passengers integer NOT NULL,
    contact_number numeric(12,0) NOT NULL,
    e_mail character(20) NOT NULL,
    flight_id numeric(12,0)
);
 $   DROP TABLE public.charter_services;
       public         heap    postgres    false            �            1259    26449 	   departure    TABLE     �   CREATE TABLE public.departure (
    departure_from text NOT NULL,
    date date,
    departure_time time without time zone NOT NULL,
    aircraft_id character(12),
    flight_id numeric(12,0)
);
    DROP TABLE public.departure;
       public         heap    postgres    false            �            1259    26452    express_mail    TABLE     �   CREATE TABLE public.express_mail (
    mail_id numeric(12,0) NOT NULL,
    type character(12) NOT NULL,
    price numeric(12,0) NOT NULL,
    flight_id numeric(12,0)
);
     DROP TABLE public.express_mail;
       public         heap    postgres    false            �            1259    26455    flights    TABLE     �   CREATE TABLE public.flights (
    flight_id numeric(12,0) NOT NULL,
    aircraft_id text,
    cap_id numeric(12,0),
    departure_arrival text NOT NULL,
    flight_time text NOT NULL,
    availability boolean NOT NULL
);
    DROP TABLE public.flights;
       public         heap    postgres    false            �            1259    26458    food    TABLE     �   CREATE TABLE public.food (
    meal_1 character(12),
    meal_2 character(12),
    meal_3 character(12),
    drink character(12) NOT NULL,
    dessert character(12) NOT NULL,
    flight_id numeric(12,0)
);
    DROP TABLE public.food;
       public         heap    postgres    false            �            1259    26461 	   passenger    TABLE     3  CREATE TABLE public.passenger (
    passenger_id numeric(12,0) NOT NULL,
    name text NOT NULL,
    surname text NOT NULL,
    age integer NOT NULL,
    nationality character(12) NOT NULL,
    phone_number numeric(12,0) NOT NULL,
    seat_id numeric(12,0) NOT NULL,
    ticket_id numeric(12,0) NOT NULL
);
    DROP TABLE public.passenger;
       public         heap    postgres    false            �            1259    26464    revenue_date    TABLE     e   CREATE TABLE public.revenue_date (
    date_day date NOT NULL,
    revenue numeric(12,0) NOT NULL
);
     DROP TABLE public.revenue_date;
       public         heap    postgres    false            �            1259    26467    ticket    TABLE     �   CREATE TABLE public.ticket (
    ticket_id numeric(12,0) NOT NULL,
    price numeric(12,0),
    flight_id numeric(12,0),
    type character(12) NOT NULL,
    number_of_sold integer,
    number_of_available integer
);
    DROP TABLE public.ticket;
       public         heap    postgres    false            �          0    26434    aircraft 
   TABLE DATA           @   COPY public.aircraft (aircraft_id, model, capacity) FROM stdin;
    public          postgres    false    200   >       �          0    26437    arrival 
   TABLE DATA           Y   COPY public.arrival (arrival_to, date, arrival_time, aircraft_id, flight_id) FROM stdin;
    public          postgres    false    201   ]?       �          0    26440    captain 
   TABLE DATA           L   COPY public.captain (cap_id, name, surname, hired_date, salary) FROM stdin;
    public          postgres    false    202   �@       �          0    26443    cargo_service 
   TABLE DATA           a   COPY public.cargo_service (type, weight, packing_method, price, flight_id, cargo_id) FROM stdin;
    public          postgres    false    203   �C       �          0    26446    charter_services 
   TABLE DATA           l   COPY public.charter_services (company, number_of_passengers, contact_number, e_mail, flight_id) FROM stdin;
    public          postgres    false    204   �D       �          0    26449 	   departure 
   TABLE DATA           a   COPY public.departure (departure_from, date, departure_time, aircraft_id, flight_id) FROM stdin;
    public          postgres    false    205   F       �          0    26452    express_mail 
   TABLE DATA           G   COPY public.express_mail (mail_id, type, price, flight_id) FROM stdin;
    public          postgres    false    206   WG       �          0    26455    flights 
   TABLE DATA           o   COPY public.flights (flight_id, aircraft_id, cap_id, departure_arrival, flight_time, availability) FROM stdin;
    public          postgres    false    207   H       �          0    26458    food 
   TABLE DATA           Q   COPY public.food (meal_1, meal_2, meal_3, drink, dessert, flight_id) FROM stdin;
    public          postgres    false    208   FK       �          0    26461 	   passenger 
   TABLE DATA           t   COPY public.passenger (passenger_id, name, surname, age, nationality, phone_number, seat_id, ticket_id) FROM stdin;
    public          postgres    false    209   ZL       �          0    26464    revenue_date 
   TABLE DATA           9   COPY public.revenue_date (date_day, revenue) FROM stdin;
    public          postgres    false    210   N       �          0    26467    ticket 
   TABLE DATA           h   COPY public.ticket (ticket_id, price, flight_id, type, number_of_sold, number_of_available) FROM stdin;
    public          postgres    false    211   yN       Q           2606    26471    aircraft aircraft_id 
   CONSTRAINT     [   ALTER TABLE ONLY public.aircraft
    ADD CONSTRAINT aircraft_id PRIMARY KEY (aircraft_id);
 >   ALTER TABLE ONLY public.aircraft DROP CONSTRAINT aircraft_id;
       public            postgres    false    200            S           2606    26473    captain cap_id 
   CONSTRAINT     P   ALTER TABLE ONLY public.captain
    ADD CONSTRAINT cap_id PRIMARY KEY (cap_id);
 8   ALTER TABLE ONLY public.captain DROP CONSTRAINT cap_id;
       public            postgres    false    202            U           2606    26475    cargo_service cargo_id 
   CONSTRAINT     Z   ALTER TABLE ONLY public.cargo_service
    ADD CONSTRAINT cargo_id PRIMARY KEY (cargo_id);
 @   ALTER TABLE ONLY public.cargo_service DROP CONSTRAINT cargo_id;
       public            postgres    false    203            _           2606    26477    revenue_date date_day 
   CONSTRAINT     Y   ALTER TABLE ONLY public.revenue_date
    ADD CONSTRAINT date_day PRIMARY KEY (date_day);
 ?   ALTER TABLE ONLY public.revenue_date DROP CONSTRAINT date_day;
       public            postgres    false    210            Y           2606    26479    flights flight_id 
   CONSTRAINT     V   ALTER TABLE ONLY public.flights
    ADD CONSTRAINT flight_id PRIMARY KEY (flight_id);
 ;   ALTER TABLE ONLY public.flights DROP CONSTRAINT flight_id;
       public            postgres    false    207            W           2606    26481    express_mail mail_id 
   CONSTRAINT     W   ALTER TABLE ONLY public.express_mail
    ADD CONSTRAINT mail_id PRIMARY KEY (mail_id);
 >   ALTER TABLE ONLY public.express_mail DROP CONSTRAINT mail_id;
       public            postgres    false    206            [           2606    26483    passenger passenger_id 
   CONSTRAINT     ^   ALTER TABLE ONLY public.passenger
    ADD CONSTRAINT passenger_id PRIMARY KEY (passenger_id);
 @   ALTER TABLE ONLY public.passenger DROP CONSTRAINT passenger_id;
       public            postgres    false    209            ]           2606    26485    passenger passenger_seat_id_key 
   CONSTRAINT     ]   ALTER TABLE ONLY public.passenger
    ADD CONSTRAINT passenger_seat_id_key UNIQUE (seat_id);
 I   ALTER TABLE ONLY public.passenger DROP CONSTRAINT passenger_seat_id_key;
       public            postgres    false    209            a           2606    26487    ticket ticket_id 
   CONSTRAINT     U   ALTER TABLE ONLY public.ticket
    ADD CONSTRAINT ticket_id PRIMARY KEY (ticket_id);
 :   ALTER TABLE ONLY public.ticket DROP CONSTRAINT ticket_id;
       public            postgres    false    211            b           2606    26488    arrival ar_airc_id    FK CONSTRAINT     �   ALTER TABLE ONLY public.arrival
    ADD CONSTRAINT ar_airc_id FOREIGN KEY (aircraft_id) REFERENCES public.aircraft(aircraft_id);
 <   ALTER TABLE ONLY public.arrival DROP CONSTRAINT ar_airc_id;
       public          postgres    false    201    200    2897            c           2606    26493    arrival ar_date    FK CONSTRAINT     x   ALTER TABLE ONLY public.arrival
    ADD CONSTRAINT ar_date FOREIGN KEY (date) REFERENCES public.revenue_date(date_day);
 9   ALTER TABLE ONLY public.arrival DROP CONSTRAINT ar_date;
       public          postgres    false    2911    210    201            d           2606    26498    arrival ar_flight_id    FK CONSTRAINT     ~   ALTER TABLE ONLY public.arrival
    ADD CONSTRAINT ar_flight_id FOREIGN KEY (flight_id) REFERENCES public.flights(flight_id);
 >   ALTER TABLE ONLY public.arrival DROP CONSTRAINT ar_flight_id;
       public          postgres    false    207    201    2905            e           2606    26503    cargo_service cargo_flight_id    FK CONSTRAINT     �   ALTER TABLE ONLY public.cargo_service
    ADD CONSTRAINT cargo_flight_id FOREIGN KEY (flight_id) REFERENCES public.flights(flight_id);
 G   ALTER TABLE ONLY public.cargo_service DROP CONSTRAINT cargo_flight_id;
       public          postgres    false    203    207    2905            f           2606    26508 !   charter_services chartr_flight_id    FK CONSTRAINT     �   ALTER TABLE ONLY public.charter_services
    ADD CONSTRAINT chartr_flight_id FOREIGN KEY (flight_id) REFERENCES public.flights(flight_id);
 K   ALTER TABLE ONLY public.charter_services DROP CONSTRAINT chartr_flight_id;
       public          postgres    false    204    2905    207            g           2606    26513    departure dep_airc_id    FK CONSTRAINT     �   ALTER TABLE ONLY public.departure
    ADD CONSTRAINT dep_airc_id FOREIGN KEY (aircraft_id) REFERENCES public.aircraft(aircraft_id);
 ?   ALTER TABLE ONLY public.departure DROP CONSTRAINT dep_airc_id;
       public          postgres    false    200    205    2897            h           2606    26518    departure dep_date    FK CONSTRAINT     {   ALTER TABLE ONLY public.departure
    ADD CONSTRAINT dep_date FOREIGN KEY (date) REFERENCES public.revenue_date(date_day);
 <   ALTER TABLE ONLY public.departure DROP CONSTRAINT dep_date;
       public          postgres    false    205    210    2911            i           2606    26523    departure dep_flight_id    FK CONSTRAINT     �   ALTER TABLE ONLY public.departure
    ADD CONSTRAINT dep_flight_id FOREIGN KEY (flight_id) REFERENCES public.flights(flight_id);
 A   ALTER TABLE ONLY public.departure DROP CONSTRAINT dep_flight_id;
       public          postgres    false    2905    205    207            j           2606    26528    express_mail express_flight_id    FK CONSTRAINT     �   ALTER TABLE ONLY public.express_mail
    ADD CONSTRAINT express_flight_id FOREIGN KEY (flight_id) REFERENCES public.flights(flight_id);
 H   ALTER TABLE ONLY public.express_mail DROP CONSTRAINT express_flight_id;
       public          postgres    false    206    2905    207            l           2606    26558    flights f_airc_id    FK CONSTRAINT     �   ALTER TABLE ONLY public.flights
    ADD CONSTRAINT f_airc_id FOREIGN KEY (aircraft_id) REFERENCES public.aircraft(aircraft_id);
 ;   ALTER TABLE ONLY public.flights DROP CONSTRAINT f_airc_id;
       public          postgres    false    200    2897    207            k           2606    26538    flights f_cap_id    FK CONSTRAINT     t   ALTER TABLE ONLY public.flights
    ADD CONSTRAINT f_cap_id FOREIGN KEY (cap_id) REFERENCES public.captain(cap_id);
 :   ALTER TABLE ONLY public.flights DROP CONSTRAINT f_cap_id;
       public          postgres    false    207    202    2899            m           2606    26543    food food_flight_id    FK CONSTRAINT     }   ALTER TABLE ONLY public.food
    ADD CONSTRAINT food_flight_id FOREIGN KEY (flight_id) REFERENCES public.flights(flight_id);
 =   ALTER TABLE ONLY public.food DROP CONSTRAINT food_flight_id;
       public          postgres    false    208    207    2905            n           2606    26548    passenger pass_ticket_id    FK CONSTRAINT     �   ALTER TABLE ONLY public.passenger
    ADD CONSTRAINT pass_ticket_id FOREIGN KEY (ticket_id) REFERENCES public.ticket(ticket_id);
 B   ALTER TABLE ONLY public.passenger DROP CONSTRAINT pass_ticket_id;
       public          postgres    false    209    211    2913            o           2606    26553    ticket ticket_flight_id    FK CONSTRAINT     �   ALTER TABLE ONLY public.ticket
    ADD CONSTRAINT ticket_flight_id FOREIGN KEY (flight_id) REFERENCES public.flights(flight_id);
 A   ALTER TABLE ONLY public.ticket DROP CONSTRAINT ticket_flight_id;
       public          postgres    false    207    211    2905            �   K  x�u��n�0���S�U�?qr�K�**H�zI B���!<wQ���s[}�ݙ�p9����p�ê�&j]�;n�A��� ������绖���b�]�7��� (�>UX\ޭ��r�\��L��J4Uk��g�b�Z�c4e@��J2ś�)����,�� �@��W"iu.�T�+����oi��3�Q	��I��C��b����};���b2�m�����{�*1icyȲr����&CF@�.���u�P��,X���`�92qJ��j	-�Z�:2W女�D���7�ǩȈ��t�.��M�{n��Ty��DuQF)5����Ѥ      �   5  x�m��R�0��s�)|��MҴ�ё�#x���(&3��m!ӦBO=��k�o�;�;�#�i�,H[F�(���.]���a��!�,m�[�H��-3�"6��4X������j쭔f��k\�jg�2l��R
���a;�B��2��p�������)�Uxu��(`�]h�la£�Xv!�`K���i�W�-���х�V�*Kx�rUU���c؞6�&�4���O~�WCJ!jR�QB���G������b��ӯ���no-���'69��	uf^�0�t�)��gX#��!�c�#�)ґ����= ��9��      �   �  x�U��n�@E�����E���q��IP�(�}K�5�X*Fr���Kj�#�E����r���������)`ӍJH�"�6F��Ppur��xغj���Ì'���T�`\ö�M?�p��q�~�.�X�X�Rx϶)��b�em˺�p�b���ھ�Y̕}���݈��Hc�!��l�1������U�t*b�b���:�ak+��k�e;6:HO��̠�9��6��xhO��)Ӛ}l��lZ�ݬ�Ch�E�|BA�i����E�өC:�Q
yGʹ8ٿ��������plS�c�ܨd�e
4!I�"ڷH>�}�ߵ���T�l�s6Qj218����Ut!��k��t/���~�X���G�S�&D��n�w����\Y��E�t ��(Et�6�0���<�f�MAIx��R�e/�{�͆Ľ��I������mx�\c��X�q�&&+�h�X��sT��vK�2�Ɠ*��hF��o�O�ϭ���i%���
ʹ������W��y�;��� Z�5�ach!�-��δfi��<���aYe��-om�����pgOT28���5��m�9'�Tc�3�S����۶Z��
y������������h�.��>H�m�5x��"�G��h���6ܘ�h���ڏ��;�sP�$\�b�
x�]7�9l���y��6+�4��Yr��V��9.�j�!v�'Z�~}Z�V�NC1�      �     x������0�k�S�	���J~�骜t͆b)��1�׿5?ő��b�ѷ��-:�<�כ�.����c�P���J��A_����-R�e$�a��&k��Ag"��8^�ʲ���a7���D��]�5�}���`�Ɔ�8��bIE�\��+|a�;tҼ:o�qR`�EXT���Ndz,���#�(�9S�G=�i��P��þ���Ε�+��ĚCaO�ώ���E�#3b-`��iԽ�ȁ-���O��t�TF�zjT����� ~Y͐V      �   _  x�e��r1�k�S�	vH��8.ҥI���+q��\h�T|<}(YJF
k|��������w��E˵d����|H5n=m�y�����{V(R�P*�ҒE����(�H)�3��1�,*�Ҡ�/�rXѯ��>�O6�9�}Yz��5�25���>/+	?S��!]c	ƺ�DS9��V���Z#�C\�V�e��6X6���>�}bw2%4Z��|y�5���~�������r.�`� ��M�L�����g���Z���P�gfl��j�q���l|麭q��	(ڡ�h���no�D4�؏������!���@�V*�5�mX�RSt~.�O7����?���      �   B  x�m��n�0е�+��f���.TQ�*������Q,BF�a�|}IJmh���pu�.z�Z��:�G���0�r��%qy3>���ɸ�ʕsFbď$Ӏ9簮��u�
��hWo
�B���Õ��6��/�Z����6�kM��QJk�R
��l�HFI.�k$Iϝ){�fH9��Bk/�N�u�P�jL�A�i
��q�����g��Xd�{Y���\�#&d���D���w[?�T.��$q�	aS��Mw�,�?v3����m�7�tl���?�b�uc�_��e(�j�%?�����ɸa���	W۶���u�1KN>n����      �   �   x�=���@D��W��v�.\ţDѓB1�,r���M���y�i�ܚc��LL�
ܵuM��� ���L�<��K��m���"P�y�5G�n	�v��q��D�Z����
(��0|��nؒ8 P,j7�/ ��F�.t��,`la)��?�O[9f|��V�1M      �   (  x�e��r�0�����Ա��Kh�Cm&�t:ӛ��bK�n&}�������￻�Â<�l���|a�����pD2�}�H�u�̄p�UN�|A�ۺ�:b����i�������	}�`e�G����;��g�+�k���-5�9��w0%��.�F��G�i�RZЗ�<�����ge��Y�MV�����`k�����r�xh�ڮT(��#�s�[�%l������<dG�ӢW.�b*�cK!�%�-���6O�dr����l���ٜ����%��*��
k�`X���֚?�y5��uw���-���n���\�y����Ƅ=Vtbqj�>�T����'��	eZVؼ��;��ԝ��=�3)�s�-��e>�$�����������O�r���BN���B���м��f��S�I���*`I�:��s�h� \���MBW[�.f�]�!����Q�6��f��	���Xs��m�%���l�,_pw��xF�+:�����Y��Uw��ah�OhLpZb���RB�W<���ݱ=������y�Y��q/X��i՚�m��^rM����SѰE�d,[[�,���wp�q7�׊�7|�%	sz�h!�}`ݤ�x|պM�d�I�;CK��[�.#!�w��iy�U`�8�T1���$0�����Wg��7+b�JDl��ų��e'6ެ:(���*d���%i�3��`4�����"�G~�O�n؇�������Dl�����Q�p�}�P����lP������-`Y���l�2���w���7��      �     x�}Q�n�0<�_�������R��B��\�d,���!__�`d�RW��jggf]u��4�KyoLv�Z^�R�Ǚ�d@����0aGt�;�����O���-��ᰀ(����#����֯�'6.�N�\�����1��H�Y��TǦ��$	| ��oZC����lx�aG?MSxG�ב6�?���dYΚA�8֥4�\!�Wa6���� y�C��w���MX8��7�m�,Kp>�f=�Xr�\�5�c.� N� �a݉�      �   �  x�e�Ao!�Ϗ_�?�
`�cZՍb�J#G���F�f%֫�����n.�8��{��{g4���?�>��T{X�u�uu;�H�9�y�1F�&�۩�Tj��T�S�3,cwH�]�4��9��<�
���.x*���b>������uQ�)��╖V2�y�cɳx�(N��l��N�0��S�������y�g�Ǘ��|�jB�]X���+�db�:��2c�J{��+��&]�p���Zv]G�k�ֆ�iLC�s��c7��2�������,Vް�C�t�>?��2�`:�ұ�� 
h6L,��zDElI|�j O�tjg�����mi�N18��mv����e���4������S+oB�N;�I+�V̌��l��_C����Adǎ$?�%�Q1F�K���O0�?E'l�|cկ�J�?V��B      �   Q   x�Mι�0Cњ�%���.���Id��X|���؃F��g�{��m��<���NXV�'t1��n�_�߃��=�-"/Rwp      �   �   x�}��1D�UT���OHW�CBB���l�y�W4f�n���y�Hc(���F;�3[�����p�Z$Dމ�]z,_,����Y�ֺ%k�`j٘�Zۢ�ۧ���{!L�U�
g~�|f�s��i��A���"A�     