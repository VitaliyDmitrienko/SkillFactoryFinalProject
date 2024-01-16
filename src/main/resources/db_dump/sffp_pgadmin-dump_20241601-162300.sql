PGDMP                           |            sffp    15.3    15.4                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16398    sffp    DATABASE     x   CREATE DATABASE sffp WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Russian_Russia.1251';
    DROP DATABASE sffp;
                postgres    false            �            1259    16399 	   depositor    TABLE     U   CREATE TABLE public.depositor (
    id bigint NOT NULL,
    balance numeric(38,2)
);
    DROP TABLE public.depositor;
       public         heap    postgres    false            �            1259    16402    depositor_id_seq    SEQUENCE     �   CREATE SEQUENCE public.depositor_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.depositor_id_seq;
       public          postgres    false    214            	           0    0    depositor_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.depositor_id_seq OWNED BY public.depositor.id;
          public          postgres    false    215            �            1259    16406 	   operation    TABLE     �   CREATE TABLE public.operation (
    id bigint NOT NULL,
    depositor_id bigint NOT NULL,
    operation_type integer NOT NULL,
    changebalance numeric(38,2),
    operation_date timestamp without time zone
);
    DROP TABLE public.operation;
       public         heap    postgres    false            �            1259    16409    operation_id_seq    SEQUENCE     �   CREATE SEQUENCE public.operation_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.operation_id_seq;
       public          postgres    false    216            
           0    0    operation_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.operation_id_seq OWNED BY public.operation.id;
          public          postgres    false    217            j           2604    16410    depositor id    DEFAULT     l   ALTER TABLE ONLY public.depositor ALTER COLUMN id SET DEFAULT nextval('public.depositor_id_seq'::regclass);
 ;   ALTER TABLE public.depositor ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    215    214            k           2604    16419    operation id    DEFAULT     l   ALTER TABLE ONLY public.operation ALTER COLUMN id SET DEFAULT nextval('public.operation_id_seq'::regclass);
 ;   ALTER TABLE public.operation ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    217    216            �          0    16399 	   depositor 
   TABLE DATA           0   COPY public.depositor (id, balance) FROM stdin;
    public          postgres    false    214   �                 0    16406 	   operation 
   TABLE DATA           d   COPY public.operation (id, depositor_id, operation_type, changebalance, operation_date) FROM stdin;
    public          postgres    false    216   �                  0    0    depositor_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.depositor_id_seq', 1, false);
          public          postgres    false    215                       0    0    operation_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.operation_id_seq', 13, true);
          public          postgres    false    217            m           2606    16405    depositor depositor_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.depositor
    ADD CONSTRAINT depositor_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.depositor DROP CONSTRAINT depositor_pkey;
       public            postgres    false    214            o           2606    16421    operation operation_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.operation
    ADD CONSTRAINT operation_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.operation DROP CONSTRAINT operation_pkey;
       public            postgres    false    216            p           2606    16430 %   operation operation_depositor_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.operation
    ADD CONSTRAINT operation_depositor_id_fkey FOREIGN KEY (depositor_id) REFERENCES public.depositor(id) ON DELETE CASCADE;
 O   ALTER TABLE ONLY public.operation DROP CONSTRAINT operation_depositor_id_fkey;
       public          postgres    false    214    3181    216            �   "   x�3�4100�30�2�4�1�9u��=... x �         �   x�}��m1��m`���V-鿎x�@Nޅ��i��s�L�.�6������r+w��y��^:���7�O0\+�jI<yW�\n��HH^���ݔ9<��n�+>��1�e�7�����0�J���o�S}pؐ�-q�Q�#I���3ei��� _�jB9��</�g��9��)x��}L���+s?�����`_      